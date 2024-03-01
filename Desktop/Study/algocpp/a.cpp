#include <bits/stdc++.h>
using namespace std;
double a(); // 선언
int main(){ // main 함수이다.
    double ret = a();
    cout << ret << '\n';
    return 0;

}

double a(){ // 왜 여기다가 정의를 해두는 것 인가?
    return 1.2333;
}