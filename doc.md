# Documentation

# Get auth token

### Request:

```shell
curl -X POST -d '{
    "username" : "changeme",
    "password" : "changeme"
}' "http://127.0.0.1:8080/auth/signin"
```

### Response

```json
{
  "username": "changeme",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaGFuZ2VtZSIsInJvbGVzIjoiUk9MRV9VU0VSLFJPTEVfQURNSU4iLCJpYXQiOjE2NDQyNDEwNjYsImV4cCI6MTY0NDI0NDY2Nn0.0WBE_YwiYPWWEL3J6JT8WLJP-quOKScqcRx4zna2LyM"
}
```

# Send verification email

```shell
curl -X POST "http://127.0.0.1:8080 /api/v1/send?email=test@gmail.com"
```

### Response

```json
{
  "id": "e3608186-5c09-45c3-9dfe-e52754ab2cb3",
  "address": "test@gmail.com",
  "code": "776247",
  "sendTime": "2022-02-07T17:31:13.925822",
  "validTime": "2022-02-07T17:36:13.925822"
}
```

# Validate the code

```shell
curl -X GET "http://127.0.0.1:8080 /api/v1/validate?email=test@gmail.com&code=980122"
```

### Response

```json
{
  "valid": true
}
```

# Get a list of all codes

```shell
curl -X GET "http://127.0.0.1:8080 /api/v1/emails"
```

### Response

```json
[
  {
    "id": "d7c7d0be-46b9-4d22-a20a-6b8e0d005b93",
    "address": "test@gmail.com",
    "code": "980122",
    "sendTime": "2022-02-07T17:28:58.886417",
    "validTime": "2022-02-07T17:33:58.886417"
  },
  {
    "id": "e3608186-5c09-45c3-9dfe-e52754ab2cb3",
    "address": "test@gmail.com",
    "code": "776247",
    "sendTime": "2022-02-07T17:31:13.925822",
    "validTime": "2022-02-07T17:36:13.925822"
  }
]
```

# Get a single email by id

```shell
curl -X GET "http://127.0.0.1:8080 /api/v1/email/d7c7d0be-46b9-4d22-a20a-6b8e0d005b93"
```

### Response

```json
{
  "id": "d7c7d0be-46b9-4d22-a20a-6b8e0d005b93",
  "address": "test@gmail.com",
  "code": "980122",
  "sendTime": "2022-02-07T17:28:58.886417",
  "validTime": "2022-02-07T17:33:58.886417"
}
```