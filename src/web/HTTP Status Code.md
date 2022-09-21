클라우드 환경에서 HTTP API를 통해 통신하는 것이 대부분이다.

이 때 응답 상태 코드를 통해 성공/실패 여부를 확인할 수 있으므로 API 문서를 작성할 때 꼭 알아야 할 것이 HTTP Status Code다

- 100번대 : 정보확인
- 200번대 : 통신 성공
- 300번대 : 리다이렉트
- 400번대 : 클라이언트 오류
- 500번대 : 서버 오류

<br>

**200번대 : 통신 성공**

| 상태코드 | 이름 | 의미 |
| --- | --- | --- |
| 200 | OK | 요청 성공 (GET) |
| 201 | Create | 생성 성공 (POST) |
| 202 | Accepted | 요청 접수, 리소스 처리 X |
| 203 | No Contents | 요청 성공, 내용 없음 |

<br>

**300번대 : 리다이렉트**

| 상태코드 | 이름 | 의미 |
| --- | --- | --- |
| 300 | Multiple Choice | 요청 URI에 여러 리소스가 존재 |
| 301 | Move Permanantly | 요청 URI가 새 위치로 옮겨감 |
| 304 | Not Modified | 요청 URI의 내용이 변경 X |

참고

300 코드는 매우 rare하게 사용된다

하나의 요청이 여러 응답을 가지고 있다는 뜻이라서 유저가 그 중 하나를 골라야 한다는 건데 이런 일은 일어나기 어려운 듯하다

<br>

**400번대 : 클라이언트 오류**

| 상태코드 | 이름 | 의미 |
| --- | --- | --- |
| 400 | Bad Request | API에서 정의되지 않은 요청이 들어옴 |
| 401 | Unauthorized | 인증 오류 |
| 403 | Forbidden | 권한 밖의 접근 시도 |
| 404 | Not Found | 요청 URI에 대한 리소스 존재하지 않음 |
| 405 | Method Not Allowed | API에 정의되지 않은 메소드 호출 |
| 406 | Not Acceptable | 처리 불가 |
| 408 | Request Timeout | 요청 대기 시간 초과 |
| 409 | Conflict | 모순 |
| 429 | Too Many Request | 요청 횟수 상한 초과 |

<br>

**500번대 : 서버 오류**

| 상태코드 | 이름 | 의미 |
| --- | --- | --- |
| 500 | Intenal Server Error | 서버 내부 오류 |
| 502 | Bad Gateway | 게이트웨이 오류 |
| 503 | Service Unavailable | 서비스 이용 불가 |
| 504 | Gateway Timeout | 게이트웨이 시간 초과 |