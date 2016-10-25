    package net.zztst.nbshop.view.base;

    import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.BaseView;


    /**
     * Created by Arron on 16/6/29.
     */

    public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
        //与Fragment绑定的activity对象
        protected BaseActivity mActivity;
        //当前View的Presenter
        protected T mPresenter;
        private View contentView;
        //通用loading页error页等的控制器
 //       private VaryViewHelperController mVaryViewHelperController;

        protected abstract void initView(View view, Bundle savedInstanceState);

        /**
         * 初始化数据 页面加载完毕调用
         */
        protected abstract void initData();

        /**
         * 切换到页面需要重新加载数据的实现此方法
         */
        public abstract void loadData();

        //获取布局文件ID
        protected abstract int getLayoutId();

        //获取宿主Activity
        protected BaseActivity getHoldingActivity() {
            return mActivity;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.mActivity = (BaseActivity) activity;
        }

        //添加fragment
        protected void addFragment(BaseFragment fragment) {
            if (null != fragment) {
                getChildFragmentManager().beginTransaction()
                        .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commitAllowingStateLoss();
            }
        }

        //移除fragment
        protected void removeFragment() {
            if (getChildFragmentManager().getBackStackEntryCount() > 1) {
                getChildFragmentManager().popBackStack();
            }
        }

        //添加fragment的布局节点的ID
        protected abstract int getFragmentContentId();

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (contentView == null) {
                contentView = inflater.inflate(getLayoutId(), container, false);
                initView(contentView, savedInstanceState);
            } else {
                ViewGroup parent = (ViewGroup) contentView.getParent();
                if (parent != null) {
                    parent.removeView(contentView);
                }
            }
//            if (null == mVaryViewHelperController)
//                mVaryViewHelperController = new VaryViewHelperController(getLoaingTargetView());
            if (null == mPresenter)
                mPresenter = getChildPresenter();
            return contentView;
        }

        protected abstract T getChildPresenter();

        protected abstract View getLoaingTargetView();

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            initData();
        }

        @Override
        public void setMenuVisibility(boolean menuVisible) {
            super.setMenuVisibility(menuVisible);
            if (null != this.getView()) {
                this.getView().setVisibility(menuVisible ? View.VISIBLE : View.INVISIBLE);
            }
        }

        @Override
        public void onResume() {
            super.onResume();
            if (null != mPresenter)
                mPresenter.resume();
        }

        @Override
        public void onPause() {
            super.onPause();
            if (null != mPresenter)
                mPresenter.pause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
          //  ButterKnife.unbind(this);
            if (null != mPresenter)
                mPresenter.destroy();
        }

        @Override
        public BaseActivity getContext() {
            return mActivity;
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            //Google bug
            outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
            super.onSaveInstanceState(outState);
        }


        protected String getRequestParams() {
            return null;
        }

        @Override
        public void showMessage(String msg) {

        }

        @Override
        public void close() {

        }

        @Override
        public void showProgress(String msg) {

        }

        @Override
        public void showProgress(String msg, int progress) {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void showErrorMessage(String msg, String content) {

        }
    }