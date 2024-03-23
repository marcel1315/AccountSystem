# Zerobase Java Backend - Account System Example

- Account(계좌) 시스템은 사용자와 계좌의 정보를 저장하고 있으며, 외부 시스템에서 거래를 요청할 경우 거래 정보를 받아서 계좌에서 잔액을 거래금액만큼 줄이거나(결제), 거래금액만큼 늘리는(결제 취소) 거래 관리 기능을 제공하는 시스템입니다.

- 프로젝트 시작 시 자동으로 데이터가 입력되도록 하며, 계좌 추가/해지/확인, 거래 생성/거래 취소/거래 확인의 6가지 API를 제공한다.

    - 프로젝트 빌드시 자동입력되는 sql: src/main/resources/data.sql

    - API 요청 예시: account.http, transaction.http

- 프로젝트 스펙

    - Spring Boot 3.1.9

    - Java 17

    - DB

        - H2. jdbc:h2:mem:test 로 접속

        - Embedded Redis

        - JPA 사용해서 DB 접근

    - json API
    

# APIs

### 계좌 생성

- POST http://localhost:8080/account

- Content-Type: application/json

```json
{
  "userId": 1,
  "initialBalance": 10000
}
```

### 계좌 해지

- DELETE http://localhost:8080/account

- Content-Type: application/json

```json
{
  "userId": 1,
  "accountNumber": "6092151117"
}
```

### 계좌 확인

- GET http://localhost:8080/account?user_id=1

- Accept: application/json

### 거래 생성

- POST http://localhost:8080/transaction/use

- Content-Type: application/json

```json
{
  "userId": 1,
  "accountNumber": "7389927179",
  "amount": 100
}
```

### 거래 취소

- POST http://localhost:8080/transaction/cancel

- Content-Type: application/json

```json
{
  "transactionId": "b5574ed867624122a35fe3f25432ae6d",
  "accountNumber": "2855891162",
  "amount": 10000
}
```

### 거래 조회

- GET http://localhost:8080/transaction/6aaece97ded045f5a4bc127b2a4b9ac3
