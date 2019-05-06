DelayTextWatcher
​
![image](https://github.com/palmyer/DelayTextWatcher/blob/master/20190506_113426.gif)

- 延迟回调TextWatcher

- 用法

```aidl
mEditText.addTextChangedListener(new SearchTextWatcher(new SearchTextWatcher.SearchCallback() {
    @Override
    public void getKeywords(String keywords) {
        mTextView.setText(keywords);
    }
}));
```
