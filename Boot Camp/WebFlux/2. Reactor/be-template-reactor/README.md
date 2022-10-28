# 상황별로 분류된 Operator 목록 리뷰

### 새로운 Sequence를 생성(Creating)하고자 할 경우
>just()
⭐ fromStream()
⭐ fromIterable()
fromArray()
range()
interval()
empty()
never()
defer()
using()
generate()
⭐ create()

### 기존 Sequence에서 변환 작업(Transforming)이 필요한 경우
>⭐ map()
⭐ flatMap()
⭐ concat()
collectList()
collectMap()
merge()
⭐ zip()
then()
switchIfEmpty()
and()
when()

### Sequence 내부의 동작을 확인(Peeking)하고자 할 경우
>doOnSubscribe
⭐doOnNext()
doOnError()
doOnCancel()
doFirst()
doOnRequest()
doOnTerminate()
doAfterTerminate()
doOnEach()
doFinally()
⭐log()

### Sequence에서 데이터 필터링(Filtering)이 필요한 경우
>⭐filter()
ignoreElements()
distinct()
⭐take()
next()
skip()
sample()
single()

### 에러를 처리(Handling errors)하고자 할 경우
>⭐error()
⭐timeout()
onErrorReturn()
onErrorResume()
onErrorMap()
doFinally()
⭐retry()