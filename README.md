# retrofitx
Call API in a very simple way with Kotlin Extensions

## Example
```
getResponse(getApis().getUser(), onApiSuccess = {
     //Handle Response
     txtName.text = it.name
}, onApiError = {
     //Handle Api Error
     toast(it)
}, onNetworkError = {
     //Handle No Internet Connection
})
