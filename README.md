# Bank Account API

## Description
Ce projet est une API REST pour la gestion des comptes bancaires et des clients. Il permet de créer, lire, mettre à jour et supprimer des comptes et des clients.

## Prérequis
- Java 11 ou supérieur
- Maven 3.6 ou supérieur
- Spring Boot 2.5 ou supérieur

## Installation
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/votre-utilisateur/bankaccount.git
   ```
2. Accédez au répertoire du projet :
   ```bash
   cd bankaccount
   ```
3. Compilez le projet avec Maven :
   ```bash
   mvn clean install
   ```

## Exécution
Pour exécuter l'application, utilisez la commande suivante :
```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse `http://localhost:8080`.

## Endpoints

### Customer Endpoints
- **Ajouter un client**
  - **Méthode HTTP** : `POST`
  - **URL** : `/api/customers`
  - **En-tête** : `Content-Type: application/json`
  - **Corps de la requête** :
    ```json
    {
      "name": "John Doe",
      "email": "johndoe@example.com"
    }
    ```

### Account Endpoints
- **Ajouter un compte**
  - **Méthode HTTP** : `POST`
  - **URL** : `/api/account`
  - **En-tête** : `Content-Type: application/json`
  - **Paramètre de requête** : `customerId`
  - **Exemple** :
    ```bash
    curl -X POST "http://localhost:8080/api/account?customerId=1"
    ```

- **Déposer de l'argent sur un compte**
  - **Méthode HTTP** : `PUT`
  - **URL** : `/api/account/deposit`
  - **En-tête** : `Content-Type: application/json`
  - **Corps de la requête** :
    ```json
    {
      "accountId": 1,
      "amount": 500.0
    }
    ```

- **Retirer de l'argent d'un compte**
  - **Méthode HTTP** : `PUT`
  - **URL** : `/api/account/withdraw`
  - **En-tête** : `Content-Type: application/json`
  - **Corps de la requête** :
    ```json
    {
      "accountId": 1,
      "amount": 200.0
    }
    ```

- **Obtenir les détails d'un compte**
  - **Méthode HTTP** : `GET`
  - **URL** : `/api/account/{id}`
  - **Exemple** :
    ```bash
    curl -X GET "http://localhost:8080/api/account/1"
    ```

- **Obtenir tous les comptes**
  - **Méthode HTTP** : `GET`
  - **URL** : `/api/account`
  - **Exemple** :
    ```bash
    curl -X GET "http://localhost:8080/api/account"
    ```

- **Obtenir les comptes par ID de client**
  - **Méthode HTTP** : `GET`
  - **URL** : `/api/account/customer/{customerId}`
  - **Exemple** :
    ```bash
    curl -X GET "http://localhost:8080/api/account/customer/1"
    ```

- **Supprimer un compte**
  - **Méthode HTTP** : `DELETE`
  - **URL** : `/api/account/{id}`
  - **Exemple** :
    ```bash
    curl -X DELETE "http://localhost:8080/api/account/1"
    ```.
