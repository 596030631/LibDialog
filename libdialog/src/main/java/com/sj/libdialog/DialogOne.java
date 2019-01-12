package com.sj.libdialog;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
/**
 * 自定义控件-自定义对话框
 * @author
 *
 */
public class  DialogOne extends Dialog {
    private TextView titleTxv;	//标题
    private TextView msgTxv;	//提示内容文字
    private TextView positiveTxv;	//确定按钮
    private TextView negativeTxv;	//取消按钮
    public int mBackground = -1;


    /**
     * @param context
     */
    public DialogOne(Context context) {
        super(context,R.style.DialogOne);	//自定义style主要去掉标题，标题将在setCustomView中自定义设置
        setCustomView();
    }

    public DialogOne(Context context, boolean cancelable,
                        OnCancelListener cancelListener) {
        super(context, R.style.DialogOne);
        this.setCancelable(cancelable);
        this.setOnCancelListener(cancelListener);
        setCustomView();
    }
/**
 * @param background  drawable <shape> file</>*/
    public DialogOne(Context context, int background) {
        super(context, R.style.DialogOne);
        mBackground = background;
        setCustomView();
    }
    /**
     * 设置整个弹出框的视图
     */
    private void setCustomView(){
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog, null);
        if(mBackground != -1){
            mView.setBackgroundColor(mBackground);
        }
        titleTxv = mView.findViewById(R.id.title);
        msgTxv =  mView.findViewById(R.id.message);
        positiveTxv =  mView.findViewById(R.id.positiveButton);
        negativeTxv =  mView.findViewById(R.id.negativeButton);
        super.setContentView(mView);
    }

    @Override
    public void setContentView(View view){
        //重写本方法，使外部调用时不可破坏控件的视图。
        //也可以使用本方法改变CustomDialog的内容部分视图，比如让用户把内容视图变成复选框列表，图片等。这需要获取mView视图里的其它控件
    }

    @Override
    public void setTitle(CharSequence title) {
        titleTxv.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getContext().getString(titleId));
    }

    /**
     * 设置提示内容文字
     * @param msg
     */
    public void setMessage(CharSequence msg){
        msgTxv.setText(msg);
    }
    /**
     * 设置确定键文字
     * @param text
     */
    public void setPositiveText(CharSequence text){
        positiveTxv.setText(text);
    }
    /**
     * 设置取消键文字
     * @param text
     */
    public void setNegativeText(CharSequence text){
        negativeTxv.setText(text);
    }

    /**
     * 确定键监听器
     * @param listener
     */
    public void setOnPositiveListener(View.OnClickListener listener){
        positiveTxv.setOnClickListener(listener);
    }
    /**
     * 取消键监听器
     * @param listener
     */
    public void setOnNegativeListener(View.OnClickListener listener){
        negativeTxv.setOnClickListener(listener);
    }


}
