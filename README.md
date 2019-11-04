# retrofitx
- Call API in a very simple way with Kotlin Extensions
- AndroidX
- Rxjava
- Dagger
- Android Lifecycle Architecture

## GET Example
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

```

## POST Example
```
val requestModel = RequestModel()
requestModel.name = "Bhoomin"

getResponse(getApis().createUser(requestModel), onApiSuccess = {
    txtName.text = it.name
}, onApiError = {
    //Handle Api Error
    toast(it)
}, onNetworkError = {
    //Handle No Internet Connection
})
