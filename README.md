# SpringBoot
▶ spring 공홈
https://spring.io/

▶make SpringBoot Project
https://start.spring.io/

▶ thymeleaf : templete engine
https://www.thymeleaf.org/

1. 스프링 부트는 jar로 export 해서 서버에 올려서 실행하면 된다. : java -jar 자르파일명
2. 그 때문에 jsp사용에 제약이 있는데 jsp의 경우 war로 export 해야 하고 에러처리에 문제점이 존재한다.
3. ※ 폴더 구조
      src
      └─ main
         └─ resource
            └─ templates (View: Thymeleaf, Groovy, Velocity 등)
            └─ static    (정적 컨텐츠 : html, css, js, image 등)

4. 동적페이지를 구성 할 땐 html에 thymeleaf를 쓰는것이 보편적이다.


# 인증
1. 서버기반의 인증 (Session) 과 토큰기반의 인증
      https://mangkyu.tistory.com/55
2. Json Web Token
      https://mangkyu.tistory.com/56
3. SpringBoot SpringSecurity기반의 JWT 구현
      https://mangkyu.tistory.com/57

# 배포 (MAVEN BUILD)
<pre>
pom.xml에 <![cdata[<packaging>war</packaging>]]> 추가
properties에 <start-class>Test.StartApplication</start-class> 항목을 추가하여 시작 Class지정 
</pre>
jar - https://naming0617.tistory.com/7 <br/>
war - https://4urdev.tistory.com/84

