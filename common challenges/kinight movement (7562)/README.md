## 문제 요약
체스(Chess) 게임의 나이트(Knight)의 이동 방식으로 탐색을 진행하여 목표지점에 도달하는 문제
[나이트의 이동#7562](https://www.acmicpc.net/problem/7562)
> 나이트의 이동 방식(Y자 모양): 한 칸(상하좌우) 이동 후, 이동 방향으로 대각선 중 하나를 선택해 이동

## 입력
- 테스트 케이스 개수: testCase
- 체스판 한 변의 길이: 체스판은 정사각형, length (4 ≤ length ≤ 300)
- 현재 있는 칸(나이트 시작 위치): startPosition
- 이동하려는 칸(나이트 도착 위치): targetPostion

## 출력
- 테스트 케이스마다 나이트가 이동하려는 칸까지 최소 몇 번 이동하는지 출력

## 접근 방법
나이트의 이동 방식으로 탐색하고 이동한 후 체스판 정보 클래스에 데이터 저장
- 그래프 표현 → 인접 행렬(2차원 배열)
- 탐색 → 너비 우선 탐색(Queue)
- 클래스(Class) 사용 → 탐색했을 때, 체스판 정보 저장
    - x: 행(row)
    - y: 열(column)
    - z: 깊이(depth, =이동 횟수)
> 체스판 정보 클래스(ChessboardInfo)에 이동할 때마다의 정보를 담아, 그 좌표(x, y)에 몇 번만에 이동했는지 확인