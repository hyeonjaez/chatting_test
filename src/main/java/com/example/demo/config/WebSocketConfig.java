package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // WebSocket 메시지 브로커를 활성화,  STOMP 프로토콜을 사용한 WebSocket 메시징 기능
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/portfolio").withSockJS();  // 엔드포인트 지정 및 withSockJS() SockJS 폴백 활성화
        // 브라우저가 WebSocket을 지원하지 않는 경우에도 HTTP 기반의 대체 통신이 가능
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        // 메시지 전송 경로 접두사 예를들면, /app/message 로 메세지 요청시
        // 서버의 특정 메서드 인 @MessageMapping 이 메세지를 처리한다

        config.enableSimpleBroker("/topic", "/queue");
        // 간단한 메시지 브로커 활성화
        //topic : 여러 클라이언트가 구독하는 브로드캐스트 채널
        // queue : 1:1 메시지를 주고받는 개인 메세지 큐 경로
    }
}
