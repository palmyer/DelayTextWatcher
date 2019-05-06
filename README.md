# SearchTextWatcher
​
![image](https://raw.githubusercontent.com/palmyer/LoadingImageView/master/images/device-2018-06-06-153223.png)

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