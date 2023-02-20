## 문제 요약
[행렬#1080](https://www.acmicpc.net/problem/1080)

- 0과 1로만 이루어진 행렬 A, B
- 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 <u>**최솟값**</u>을 구하는 프로그램을 작성
    > 행렬을 변환하는 연산은 <u>어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것</u> (0 → 1, 1 → 0)

## 입력
- $N M$: 형렬의 크기 $N, M\, (1 <= N, M <= 50)$
- N개의 줄: 행렬 A
- N개의 줄: 행렬 B

## 출력
- 연산 횟수의 최솟값 출력 (단, A를 B로 바꿀수 없다면 -1)

## 접근 방법
경우의 수 많고 최솟값 요구하는 문제 → '그리디 알고리즘' 또는 '이진 탐색' → (문제에서 제시된) 현재 상태에서 최선의 해를 이용해 결과 도출
- 그리디 알고리즘

> [배열(Array) 비교](https://www.notion.so/Array-07fcfdf2d9af48fcaf66c839cc99fb66?pvs=4)