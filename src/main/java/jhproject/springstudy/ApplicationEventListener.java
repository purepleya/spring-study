package jhproject.springstudy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
@Slf4j
public class ApplicationEventListener {


    // Published when the ApplicationContext is initialized or refreshed (for example, by using the refresh() method on the ConfigurableApplicationContext interface). Here, “initialized” means that all beans are loaded, post-processor beans are detected and activated, singletons are pre-instantiated, and the ApplicationContext object is ready for use. As long as the context has not been closed, a refresh can be triggered multiple times, provided that the chosen ApplicationContext actually supports such “hot” refreshes. For example, XmlWebApplicationContext supports hot refreshes, but GenericApplicationContext does not.
    // ApplicationContext가 초기화 또는 새로 고침 될 때 발행됩니다 (예 : ConfigurableApplicationContext 인터페이스의 refresh () 메소드를 사용하여).
    // 여기서 "초기화"는 모든 빈이 로드되고, 후 처리기 빈이 감지되고 활성화되고, 싱글톤이 사전 인스턴스화되고, ApplicationContext 객체가 사용할 준비가되었음을 의미합니다.
    // 컨텍스트가 닫히지 않은 한 새로 고침은 여러 번 트리거 될 수 있습니다. 선택한 ApplicationContext가 이러한 "핫"새로 고침을 실제로 지원하는 경우.
    // 예를 들어 XmlWebApplicationContext는 핫 새로 고침을 지원하지만 GenericApplicationContext는 지원하지 않습니다.
    @EventListener({ContextRefreshedEvent.class})
    public void handleRefreshEvent() {
//        log.info("ApplicationContext is ready!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


    // Published when the ApplicationContext is started by using the start() method on the ConfigurableApplicationContext interface. Here, “started” means that all Lifecycle beans receive an explicit start signal. Typically, this signal is used to restart beans after an explicit stop, but it may also be used to start components that have not been configured for autostart (for example, components that have not already started on initialization).
    // ApplicationContext가 ConfigurableApplicationContext 인터페이스의 start () 메소드를 사용하여 시작될 때 발행됩니다.
    // 여기서 "시작"은 모든 Lifecycle 빈이 명시적인 시작 신호를받는다는 것을 의미합니다.
    // 일반적으로이 신호는 명시적으로 중지 한 후에 빈을 다시 시작하는 데 사용되지만 자동 시작으로 구성되지 않은 구성 요소를 시작하는 데도 사용할 수 있습니다 (예 : 초기화시 이미 시작되지 않은 구성 요소).
    @EventListener({ContextStartedEvent.class})
    public void handleStartEvent() {
//        log.warn("222222222222222222222222222222 ContextStartedEvent");
    }


    // Published when the ApplicationContext is stopped by using the stop() method on the ConfigurableApplicationContext interface. Here, “stopped” means that all Lifecycle beans receive an explicit stop signal. A stopped context may be restarted through a start() call.
    // ApplicationContext가 ConfigurableApplicationContext 인터페이스의 stop () 메소드를 사용하여 중지 될 때 발행됩니다.
    // 여기서 "중지"는 모든 Lifecycle 빈이 명시적인 중지 신호를받는다는 것을 의미합니다. 중지 된 컨텍스트는 start () 호출을 통해 다시 시작 될 수 있습니다.
    @EventListener({ContextStoppedEvent.class})
    public void handleStopEvent() {
//        log.warn("33333333333333333333333333333 ContextStoppedEvent");
    }


    // Published when the ApplicationContext is being closed by using the close() method on the ConfigurableApplicationContext interface or via a JVM shutdown hook. Here, "closed" means that all singleton beans will be destroyed. Once the context is closed, it reaches its end of life and cannot be refreshed or restarted.
    // Application 이 ConfigurableApplicationContext 인터페이스의 close () 메소드를 사용하거나 JVM 종료 후크를 통해 닫힐 때 발행됩니다.
    @EventListener({ContextClosedEvent.class})
    public void handleCloseEvent() {
//        log.warn("4444444444444444444444444444444 ContextClosedEvent");
    }


    // A web-specific event telling all beans that an HTTP request has been serviced. This event is published after the request is complete. This event is only applicable to web applications that use Spring’s DispatcherServlet.
    // HTTP 요청이 서비스되었음을 모든 빈에 알리는 웹별 이벤트입니다. 이 이벤트는 요청이 완료된 후에 발행됩니다. 이 이벤트는 Spring의 DispatcherServlet을 사용하는 웹 애플리케이션에만 적용됩니다.
    @EventListener({RequestHandledEvent.class})
    public void handleRequstEvent() {
//        log.warn("55555555555555555555555555 RequestHandledEvent");
    }


//    A subclass of RequestHandledEvent that adds Servlet-specific context information.
    // RequesHandledEvent의 하위 클래스로 Servlet별 컨텍스트 정보를 추가합니다.
    @EventListener({ServletRequestHandledEvent.class})
    public void handleServletRequestEvent() {
//        log.warn("6666666666666666666666666 ServletRequestHandledEvent");
    }


}
