> 예외처리?

  클라이언트가 에러메시지를 보다 쉽게 알 수 있도록 만들어주는 것
#
>****@ExceptionHandler****

  해당 Controller에서 발생하는 예외를 처리가 가능하다

  하지만 Controller마다 동일하게 발생하는 예외 처리를 따로 해야 되기 떄문에 에 대한 중복 코드가 발생한다.

  이를 해결하기 위해서 ****@RestControllerAdvice****를 사용한다
#
> ****@RestControllerAdvice****

  `@RestControllerAdvice`
  애너테이션을 이용해서 **예외 처리를 공통화**할 수 있다.
  각 Controller마다 추가되는 `@ExceptionHandler`로직에 대한 중복 코드를 제거하고, Controller의 코드를 단순화한다.