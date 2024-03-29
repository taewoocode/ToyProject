# 베이스 이미지 설정
FROM nginx:latest

# 작업 디렉토리 설정
WORKDIR /usr/share/nginx/html

# HTML, CSS, JS 파일 복사
COPY *.html ./
COPY *.css ./
COPY *.js ./

# 이미지 파일 복사
COPY *.jpg ./  
COPY *.png ./  
COPY *.gif ./   

# Nginx 설정 파일 복사 (필요한 경우)
#COPY nginx.conf /etc/nginx/nginx.conf

CMD ["nginx", "-g", "daemon off;"]
