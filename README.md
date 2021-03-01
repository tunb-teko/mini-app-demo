# Mini App demo

Demonstration for creating a Mini App.

## Project setup

### Adding credential for Teko's repository

In `local.properties` file, add lines as belows:

```
TekoPackage.username=<teko-package-username>
TekoPackage.password=<teko-package-token>
```

Notes: Please contact Terra team (tu.nb@teko.vn) to get `userName` and `password` to able to sync.

## Project structure

### app

The simple Super application for running Mini applications.
Intergrated modules:

- Terra
- Payment

### demoMiniApp/demoMiniNativeApp

The simple Mini application for running features supported by Terra.
Intergrated feature:

- **Payment**: request payment from Mini app to Super app
  The Super app will start the Mini app through an entry point. It is the `MiniAppActivity`.

### demoMiniApp/demoMiniNativeAppConnector

The **Connector** is responsible for initializing data and starting the Mini app. In this example, the **Connector** initializes the `MiniAppSdk` instance and start `MiniAppActivity`. To achieve this, the **Connector** must have a public class that inherited `AndroidAppLauncher` interface with two methods:

- `initApp`: initialize essential data for the Mini app (`MiniAppSdk`)
- `initIntent`: add more extra to intent that will be used to start `MiniAppActivity`
