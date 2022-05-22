
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;


public class Proxy implements HttpRequestFilter {
    private static Proxy instance;
    public static Proxy newInstance(){
        if(instance == null){
            synchronized (Proxy.class){
                if(instance == null){
                    instance = new Proxy();
                }
            }
        }
        return instance;
    }

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx){
        String uri = fullRequest.uri();
        if(uri.startsWith("/hello")){
            System.out.println("hello handler");
        } else{
            throw new RuntimeException("not support handler" + uri);
        }
        HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.add("proxy-tag", this.getClass().getSimpleName());
    }
}
