    package net.zztst.nbshop.view.base;

    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;

    import net.zztst.nbshop.NBShpApplication;
    import net.zztst.nbshop.internal.component.ActivityComponent;
    import net.zztst.nbshop.internal.component.DaggerActivityComponent;
    import net.zztst.nbshop.internal.module.ActivityModule;
    import net.zztst.nbshop.presenter.BasePresenter;
    import net.zztst.nbshop.utils.ToastUtil;
    import net.zztst.nbshop.view.BaseView;
    import net.zztst.nbshop.view.dialog.DialogManager;

    import butterknife.ButterKnife;
    import cn.pedant.SweetAlert.SweetAlertDialog;

    /**
     * Created by Arron on 16/6/29.
     */

    public abstract class AppActivity  <T extends BasePresenter> extends BaseActivity implements BaseView{

        private ActivityComponent activityComponent;
        protected Context mContext = null;//context
        private T mPresenter;

        /**
         * 获取第一个fragment  如果没有返回null即可
         */
        protected  BaseFragment getFirstFragment(){return  null;}

        @Override
        protected int getFragmentContentId() {
            return 0;
        }

        /**
         * 处理Intent
         *
         * @param intent
         */
        protected void handleIntent(Intent intent) {

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(getContentViewId());
            mContext=this;
            if (null != getIntent()) {
                handleIntent(getIntent());
            }
            ButterKnife.bind(this);
            injectDagger(getActivityComponent());
            initDataAndEvent();
            //避免重复添加Fragment
            if (null == getSupportFragmentManager().getFragments()) {
                BaseFragment firstFragment = getFirstFragment();
                if (null != firstFragment) {
                    addFragment(firstFragment);
                }
            }
            if (null == mPresenter)
                mPresenter = getChildPresenter();
        }

        public ActivityComponent getActivityComponent() {
            if (activityComponent == null) {
                activityComponent = DaggerActivityComponent.builder()
                        .activityModule(new ActivityModule(this))
                        .applicationComponent(NBShpApplication.get(this).getAppComponent())
                        .build();
            }
            return activityComponent;
        }
        protected abstract T getChildPresenter();
        protected abstract void injectDagger(ActivityComponent activityComponent);
        /**
         * 初始化data
         */
        protected abstract void initDataAndEvent();

        @Override
        public void showErrorMessage(String msg, String content) {
            DialogManager.showErrorDialog(mContext, msg, content, new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismissWithAnimation();
                }
            });
        }

        @Override
        public void hideProgress() {
            DialogManager.hideProgressDialog();
        }

        @Override
        public void showProgress(String msg, int progress) {
            DialogManager.showProgressDialog(mContext, msg, progress);
        }

        @Override
        public void showProgress(String msg) {
            DialogManager.showProgressDialog(mContext, msg);
        }

        @Override
        public void showMessage(String msg) {
            ToastUtil.showTextToast(this,msg);
        }
        @Override
        public void close() {
            finish();
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
    }