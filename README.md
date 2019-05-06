# DelayTextWatcher


![image](https://github.com/palmyer/DelayTextWatcher/blob/master/20190506_113426.gif)


- 使用RxJava
- 快速输入时阻断回调，延时(500ms)后再回调

- 用法

```aidl
        mEditText.addTextChangedListener(new DelayTextWatcher(new DelayTextWatcher.SearchCallback() {
            @Override
            public void getKeywords(String keywords) {
                mTextView.setText(keywords);
            }
        }));
```
