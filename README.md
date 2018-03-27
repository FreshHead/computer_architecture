# computer_architecture
Just simple labs.
Чтобы запустить сервер в пакете rmi 5 лабы, в папке проекта нужно:
1.  Скомпилировать классы
```
javac src/ru/univeralex/lab5/client_server/rmi/BillingService.java src/ru/univeralex/lab5/client_server/rmi/BillingServiceImpl.java src/ru/univeralex/lab5/client_server/rmi/BillingClient.java s/ru/univeralex/lab5/client_server/rmi/NotExistsCardOperation.java
```
2.  Запустить `rmiregistry`
3.  В отдельном терминале запустить сервер:
```
  java ru.univeralex.lab5.client_server.rmi.BillingServiceImpl
  ```
4.  И ещё в одном клиент:
```
  java ru.univeralex.lab5.client_server.rmi.BillingClient
  ```
