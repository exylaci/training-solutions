package stringmethods.url;

public class UrlManager {
    public final String INVALID_URL = "Invalid url";
    public final String INVALID_ARGUMENT = "Invalid argument";

    String protocol;
    Integer port;
    String host;
    String path;
    String query;

    public UrlManager(String url) {
        setProtocol(url);
        setHost(url);
        setPort(url);
        setPath(url);
        setQuery(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key){
        if (key==null || key.isBlank()){
            throw new IllegalArgumentException(INVALID_ARGUMENT);
        }
        return ("&"+query).contains("&"+key+"=");
    }

    public String getProperty(String key){
        if (!hasProperty(key)) {
            return null;
        };
        int start = ("&"+query).indexOf("?"+key+"=") + key.length() + 2;
        if ( start >= query.length() ){
            return "";
        }
        String value = query.substring( start );
        int end = value.indexOf("&");
        if ( end < 0 ){
            return value;
        }
        return value.substring(0,end);
    }

    private void setProtocol(String url){
        protocol = splitUrl(url)[0].trim().toLowerCase();
        if ( protocol.length()<1 ) {
            throw new IllegalArgumentException(INVALID_URL);
        }
    }

    private String[] splitUrl(String url){
        String[] s = url.split("://");
        if ( s.length<2 ) {
            throw new IllegalArgumentException(INVALID_URL);
        }
        return s;
    }

    private void setHost(String url) {
        host = splitProtocol(url)[0].split(":")[0].trim().toLowerCase();
        if ( host.length()<2 ) {
            throw new IllegalArgumentException(INVALID_URL);
        }
    }

    private String[] splitProtocol(String url){
        return splitUrl(url)[1].split("/");
    }

    private void setPort(String url) {
        String fullHost[] = splitProtocol(url)[0].split(":");
        if ( fullHost.length <2 ) {
            port = null;
        }else{
            try {
                port = Integer.parseInt(fullHost[1].trim());
            } catch(Exception e) {
                throw new IllegalArgumentException(INVALID_URL);
            }
        }
    }

    private void setPath(String url) {
        path ="";
        String path = splitUrl(url)[1];
        int begin = path.indexOf('/');
        if ( begin >= 0) {
            int query = path.indexOf("/query?");
            int end;
            if (query>=0) {
                end = query + 6;
            }else{
                end = path.lastIndexOf('/');
            }
            this.path = path.substring(begin,end).toLowerCase();
        }
    }

    private void setQuery(String url) {
        int pos = url.indexOf("/query");
        if ( pos > 0 ) {
            query = url.substring( pos + 7 );
        }
    }
}

// https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02
// protocol://host:port/path/path/path/path?key=value&key=value&key=value&key=value
