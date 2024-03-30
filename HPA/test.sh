#!/bin/bash

# Kubernetes 서비스의 외부 IP 주소 및 포트를 설정합니다.
SERVICE_IP=211.183.3.207
SERVICE_PORT=80

# Deployment 이름
DEPLOYMENT_NAME="my-nginx-deployment3"

# 현재 Replicas 수 확인
CURRENT_REPLICAS=$(kubectl get deployment $DEPLOYMENT_NAME -o=jsonpath='{.spec.replicas}')

# 증가할 Replicas 수
INCREASED_REPLICAS=$((CURRENT_REPLICAS + 1))

# 최소 Replicas 수 (원래의 설정값)
MIN_REPLICAS=1

echo "Sending requests to $SERVICE_IP:$SERVICE_PORT..."

# 10개의 요청을 한 번에 보냅니다.
for ((i=1; i<=10; i++)); do
  # curl을 사용하여 GET 요청을 보냅니다.
  # -s: 정적으로 요청을 보냅니다.
  # -o /dev/null: 응답을 표시하지 않습니다.
  # -w: 요청 속도 및 결과를 출력합니다.
  curl -s -o /dev/null -w "Request $i: HTTP Response Code: %{http_code}, Time taken: %{time_total} seconds\n" http://$SERVICE_IP:$SERVICE_PORT
done

echo "Load test completed."

# Pod 수 늘리기
kubectl scale deployment $DEPLOYMENT_NAME --replicas=$INCREASED_REPLICAS

echo "Increasing replicas of $DEPLOYMENT_NAME from $CURRENT_REPLICAS to $INCREASED_REPLICAS"

# 늘린 후 상태 확인
kubectl get deployment $DEPLOYMENT_NAME

# 부하 발생 후 대기 시간 (예: 1분)
sleep 60

echo "Waiting for stabilization..."

# 현재 Replicas 수 확인
CURRENT_REPLICAS=$(kubectl get deployment $DEPLOYMENT_NAME -o=jsonpath='{.spec.replicas}')

if [ $CURRENT_REPLICAS -gt $MIN_REPLICAS ]; then
  # 현재 Replicas 수가 최소 Replicas 수보다 큰 경우
  NEW_REPLICAS=$((CURRENT_REPLICAS - 1))

  echo "Decreasing replicas of $DEPLOYMENT_NAME from $CURRENT_REPLICAS to $NEW_REPLICAS"

  # Pod 수 줄이기
  kubectl scale deployment $DEPLOYMENT_NAME --replicas=$NEW_REPLICAS

  # 줄인 후 상태 확인
  kubectl get deployment $DEPLOYMENT_NAME
else
  echo "Current replicas are already at the minimum ($MIN_REPLICAS)"
fi
