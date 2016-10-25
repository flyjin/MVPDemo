package net.zztst.nbshop.presenter;

import net.zztst.nbshop.view.BaseView;

/**
 * Created by Arron on 16/7/26.
 */
public interface BasePresenter<T extends BaseView>{

    void bindView(T view);

    void resume();

    void pause();

    void destroy();


}
