package chennuo.x.xgitbook.Network;

/**
 * Created by Chen on 2017/11/20.
 */

public interface HttpResultListener<T> {

    void onSuccess(T t);

    void onError(Throwable e);
}
