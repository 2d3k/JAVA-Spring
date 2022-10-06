### DTO?
데이터를 전송하기 위한 용도의 객체

### 실습 문제
핸들러 메서드에 각 조건에 맞는 유효성 검증을 하기
1. post 핸들러 메서드에 engName에 정규표현식 적용하기, price에 최소, 최대값 적용하기
2. post 핸들러 메서드에서 적용한 것에 더불어 patch 메서드에는 유효성 검증을 선택적으로 할 수 있게 만들기 


### 영어 단어 사이에 빈칸 1개만 허용하는 정규표현식

`"^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$"`

1. `^`: Start of the line anchor
2. `[a-zA-Z]`+: Match one or more letters
3. `(?:`: Non-capturing group
4. `\s[a-zA-Z]+`: Match one or more letters after a single space
5. `?`: allow previous group zero or one time
6. `$`: End of line anchor
