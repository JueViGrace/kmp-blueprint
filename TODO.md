API:

- create error data class to display custom messages.
- make head and options method in NetworkManager.kt.
- create property for HttpClient in KtorClient.kt.

UI:

- make actual implementation of method getScreenOrientation in WindowUtilsImpl.ios.kt.
- a scaffold internal state might be needed if there's a single scaffold in the apps.
- create a screen to catch breaking errors.

Home:

- add way to include screen to the navigation graph if the screen is implemented in a separate
  module.

State:

- maybe create an error enum to check for error types and handle them differently.