# Advent of Code - Leaderboard

## Running the app

### Using docker

```
docker run -p 8080:8080 inseefrlab/adventofcodeleaderboard
```

Configuration can be set using environment variables.  
See [Configuration](#configuration)

e.g

```
docker run -p 8080:8080 --env private.group.id=12345 inseefrlab/adventofcodeleaderboard
```

### Running from source

## <a name="configuration"></a>Configuration

Configuration can be set through environment variables or by editing `application.properties` or `application-default.properties` files.  
Some parameters are mandatory.

### Auth Cookie (mandatory)

The server needs your information to log in to the AdventCode web service. You can get it by login to advent of code website and getting the cookie.

Key : `auth.cookie`  
Example : `53616c7465645f5fd78a08d3143ffba65edcb4fxxxxxxxxf6156b068623152faf4d9a5b5af28c71d705c86a30e54a76e`  
Default : ``

### Leaderboard id (mandatory)

This is the id of the leaderboard you want to display. You can get it from the `private leaderboard` page. Something like `https://adventofcode.com/YEAR/leaderboard/private/view/LEADERBOARD_ID`

Key : `private.group.id`  
Example : `12345`  
Default : ``

### Override Q & A (optional)

You can override the Q & A informations by setting the `qanda.location` property.

Key : `qanda.location`  
Example : `file:/home/user/customQandA.json`  
Default : `classpath:public/json/QandA.json`

### Override Media Section (optional)

You can override the medias' section's informations by setting the `mediaSection.location` property.

Key : `mediaSection.location`  
Example : `file:/home/user/customMediaSection.json`  
Default : `classpath:public/json/media.json`

### Override Users' Profile (optional)

You can override the users' profile informations by setting the `profiles.location` property to your config file.

Key : `profiles.location`  
Example : `file:/home/user/customProfiles.json`  
Default : `classpath:public/json/profiles.json`

### Override Language Style (optional)

You can override the languages' styles' configuration file's informations by setting the `languageStyle.location` property to your config file.

Key : `languageStyle.location`  
Example : `file:/home/user/customLanguageStyle.json`  
Default : `classpath:public/json/languageStyle.json`

### Proxy configuration (optional)

The app needs to access `adventofcode.com` to get the leaderboard data.  
If you are using it behind a proxy, you can configure it using the following parameters :

Key : `proxy.host`  
Example : `12345`  
Default : `proxy.corporation.com`

Key : `proxy.port`  
Example : `8080`  
Default : ``

Key : `proxy.use`  
Example : `true`  
Default : `false`

## Problem / Question ?

Don't be shy and send an issue.
