# Validation DSL

### 사용 예시
Validator.value("email", email)
    .notBlank()
Validator.value("name", name)
    .notBlank()
    .maxLength(8);


