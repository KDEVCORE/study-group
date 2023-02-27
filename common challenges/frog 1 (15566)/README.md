## 문제 요약
[개구리 1#15566](https://www.acmicpc.net/problem/15566)
- 연못 안에 개구리들이 있을 수 있는 연꽃 N개와, 연꽃 사이를 연결하는 다리 역할의 통나무 M개가 있다.
- 같은 연꽃 쌍을 연결하는 통나무의 개수는 1개 이하다. 여기에 N마리의 개구리가 각각 하나의 연꽃에서 휴식을 취하려 한다.
- 개구리들의 대화 주제는 4개로, 각각 음식, 취미, 가족, 철학이다. 각각의 개구리는 각 주제에 대해 흥미도를 1부터 5까지의 수 중 하나로 가진다.
- 각각의 통나무마다 대화 주제가 결정되어 있는데, <u>대화는 그 주제에 대해 두 개구리의 흥미도가 일치하면 이루어진다.</u>
- 또한, 각 개구리는 선호하는 연꽃이 1개 또는 2개가 있으며, 그 외의 연꽃에서는 불만을 가져 난장판을 만들 것이므로 모든 개구리는 자기가 선호하는 연꽃에 가야 한다.
- 개구리를 적절히 배치해 <u>모든 통나무에서 정해진 주제로 대화가 가능한지, 불가능한지와 가능하다면 그 방법을 알아내는</u> 프로그램 작성

## 입력
- $N\, M$: 연꽃의 개수 $N\,(1 \le N \le 15)$, 연꽃을 연결하는 다리 $M\,(0 \le M \le min(N(N-1)/2, 100))$
- $N$개의 줄: $N$줄 동안 각각의 개구리의 음식, 취미, 가족, 철학에 대한 흥미도 (단, 각각의 정수는 1부터 5사이)
- $N$개의 줄: 각각의 개구리가 선호하는 연꽃의 번호 $A,\, B (1 \le A,\, B \le N)$ (만약, 어떤 개구리가 선호하는 연꽃이 하나라면 $A = B$)
- $M$개의 줄: 세 정수 $A,\, B,\, T\,(1 \le A,\, B \le N,\, 1 \le T \le 4)$
    - $A$번째 연꽃과 $B$번째 연꽃을 연결하는 통나무가 있으며, 통나무의 대화 주제가 $T$번째 주제임을 뜻한다. (주제는 음식, 취미, 가족, 철학 순이다.)

## 출력
- 가능한 배치 방법이 있다면 YES, 가능한 배치 방법이 없다면 NO 출력
- (YES일 경우) 첫 번째 연꽃부터 각각의 연꽃에 배치할 개구리의 번호를 공백으로 구분해 출력. 방법이 여러 가지가 있다면 아무거나 출력해도 좋다.

## 접근 방법