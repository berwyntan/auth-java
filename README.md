# Authentication Project

- Webpage: https://auth-java-client.vercel.app 
- NOTE: Unsecure content has to be enabled on browser as the backend is on a HTTP server.
- Client: ReactJS hosted on Vercel. Link: https://github.com/berwyntan/auth-java-client
- Server: Spring Boot with Maven hosted on AWS. Link: https://github.com/berwyntan/auth-java

## Client

#### Dependencies

- Axios: API 
- i18next: multi-language support
- React hook form: forms with validation
- React router dom: routes
- Zustand: global state management

#### Features

- English and Mandarin language support using i18next
- Protected routes which require auth
- Protected routes which require manager role

## Server

#### Dependencies

- Lombok: minimize boilerplate code
- Spring dotenv: access .env file
- Starter data MongoDB: access MongoDB

#### Features

- MVC pattern
- Database: MongoDB Atlas
- Created image with Docker, host image on DockerHub: https://hub.docker.com/r/berwyntan/auth-java/tags
- Deploy to AWS EC2, using a HTTP server (HTTPS requires purchasing a domain)
