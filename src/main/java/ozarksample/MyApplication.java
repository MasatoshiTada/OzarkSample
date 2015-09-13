package ozarksample;

import java.util.HashMap;
import java.util.Map;
import javax.mvc.engine.ViewEngine;
import javax.mvc.security.Csrf;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class MyApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        
        // ビューを保存するフォルダを、好きな場所に変更できる。この設定をしない場合は、
        // ViewEngine.DEFAULT_VIEW_FOLDER(="/WEB-INF/views/")
        // の値がデフォルトとして使われる
        properties.put(ViewEngine.VIEW_FOLDER, "/WEB-INF/my-views/");
        
        // CSRFの設定。
        // EXPLICIT : プログラマが@CsrfValidを付加したメソッドのみCSRF機能を有効化する
        // IMPLICIT : CSRF機能を自動的に有効化する
        // OFF : CSRF機能を無効にする
        properties.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT);
        
        return properties;
    }
    
}
