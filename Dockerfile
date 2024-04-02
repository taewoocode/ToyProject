# 기반 이미지 설정
FROM nginx:latest

# 작업 디렉토리 설정 (옵션)
WORKDIR /usr/share/nginx/html

# 정적 파일 복사
COPY index.html .
