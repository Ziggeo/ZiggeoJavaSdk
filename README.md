# Ziggeo's Java Server SDK

latest version: **0.1.24**

## Index

1. [Why Ziggeo's Java Server Side SDK?](#why-us)
2. [Prerequisites](#prerequisites)
    1. [Download](#download)
    2. [How to use](#how-to-use)
    3. [Installation](#install)
    4. [Building](#build)
    5. [Demo](#demo)
3. [Client-Side Integration](#codes-client-side)
4. [Server-Side Integration](#codes-server-side)
    1. [Init](#codes-init)
    2. [Available Methods](#codes-methods)
    3. [Methods for Videos](#method-videos)
        1. [Videos Index](#method-videos-index)
        2. [Videos Count](#method-videos-count)
        3. [Videos Get](#method-videos-get)
        4. [Videos GetBulk](#method-videos-getbulk)
        5. [Videos StatsBulk](#method-videos-statsbulk)
        6. [Videos DownloadVideo](#method-videos-downloadvideo)
        7. [Videos DownloadImage](#method-videos-downloadimage)
        8. [Videos GetStats](#method-videos-getstats)
        9. [Videos PushToService](#method-videos-pushtoservice)
        10. [Videos ApplyEffect](#method-videos-applyeffect)
        11. [Videos ApplyMeta](#method-videos-applymeta)
        12. [Videos Update](#method-videos-update)
        13. [Videos UpdateBulk](#method-videos-updatebulk)
        14. [Videos Delete](#method-videos-delete)
        15. [Videos Create](#method-videos-create)
        16. [Videos Analytics](#method-videos-analytics)
    4. [Methods for Streams](#method-streams)
        1. [Streams Index](#method-streams-index)
        2. [Streams Get](#method-streams-get)
        3. [Streams DownloadVideo](#method-streams-downloadvideo)
        4. [Streams DownloadImage](#method-streams-downloadimage)
        5. [Streams PushToService](#method-streams-pushtoservice)
        6. [Streams Delete](#method-streams-delete)
        7. [Streams Create](#method-streams-create)
        8. [Streams AttachImage](#method-streams-attachimage)
        9. [Streams AttachVideo](#method-streams-attachvideo)
        10. [Streams AttachSubtitle](#method-streams-attachsubtitle)
        11. [Streams Bind](#method-streams-bind)
    5. [Methods for Authtokens](#method-authtokens)
        1. [Authtokens Get](#method-authtokens-get)
        2. [Authtokens Update](#method-authtokens-update)
        3. [Authtokens Delete](#method-authtokens-delete)
        4. [Authtokens Create](#method-authtokens-create)
    6. [Methods for Application](#method-application)
        1. [Application Get](#method-application-get)
        2. [Application Update](#method-application-update)
        3. [Application GetStats](#method-application-getstats)
    7. [Methods for Effect Profiles](#method-effect-profiles)
        1. [Effect Profiles Create](#method-effect-profiles-create)
        2. [Effect Profiles Index](#method-effect-profiles-index)
        3. [Effect Profiles Get](#method-effect-profiles-get)
        4. [Effect Profiles Delete](#method-effect-profiles-delete)
        5. [Effect Profiles Update](#method-effect-profiles-update)
    8. [Methods for Effect Profile Process](#method-effect-profile-process)
        1. [Effect Profile Process Index](#method-effect-profile-process-index)
        2. [Effect Profile Process Get](#method-effect-profile-process-get)
        3. [Effect Profile Process Delete](#method-effect-profile-process-delete)
        4. [Effect Profile Process CreateFilterProcess](#method-effect-profile-process-createfilterprocess)
        5. [Effect Profile Process CreateWatermarkProcess](#method-effect-profile-process-createwatermarkprocess)
        6. [Effect Profile Process EditWatermarkProcess](#method-effect-profile-process-editwatermarkprocess)
    9. [Methods for Meta Profiles](#method-meta-profiles)
        1. [Meta Profiles Create](#method-meta-profiles-create)
        2. [Meta Profiles Index](#method-meta-profiles-index)
        3. [Meta Profiles Get](#method-meta-profiles-get)
        4. [Meta Profiles Delete](#method-meta-profiles-delete)
    10. [Methods for Meta Profile Process](#method-meta-profile-process)
        1. [Meta Profile Process Index](#method-meta-profile-process-index)
        2. [Meta Profile Process Get](#method-meta-profile-process-get)
        3. [Meta Profile Process Delete](#method-meta-profile-process-delete)
        4. [Meta Profile Process CreateVideoAnalysisProcess](#method-meta-profile-process-createvideoanalysisprocess)
        5. [Meta Profile Process CreateAudioTranscriptionProcess](#method-meta-profile-process-createaudiotranscriptionprocess)
        6. [Meta Profile Process CreateNsfwProcess](#method-meta-profile-process-creatensfwprocess)
        7. [Meta Profile Process CreateProfanityProcess](#method-meta-profile-process-createprofanityprocess)
    11. [Methods for Webhooks](#method-webhooks)
        1. [Webhooks Create](#method-webhooks-create)
        2. [Webhooks Confirm](#method-webhooks-confirm)
        3. [Webhooks Delete](#method-webhooks-delete)
    12. [Methods for Analytics](#method-analytics)
        1. [Analytics Get](#method-analytics-get)
5. [License](#license)


## Why Ziggeo's Java Server Side SDK? <a name="why-us"></a>

[Ziggeo](https://ziggeo.com) is a powerfull, whitelabel video SAAS with a goal to help people with their video revolution. And what better way to do it than with an award winning multimedia API.

This server side SDK is designed to help you ease the communication with Ziggeo API. In that it allows you to privately communicate between your server and our server through requests of what you want to happen.

It offers you pre-built functionality to call and manipulate and there are demos in /demos/ directory for you to check out and use as starting point.

### Who it is for?

1. Do you have a system that requires calls to be made which should not be seen on client side?
2. Want to have an easier time handling the media as it comes to your server?
3. Want something that is simple and easy to use?
4. You need some powerful features high end video services provide?

If any of the above is "Yes" then you are in the right place as this SDK is for you!

## Prerequisites <a name="prerequisites"></a>

### Download <a name="download"></a>

You will want to either download the SDK zip file or to pull it in as git repository into your own project.

To clone it you would go into your project folder and then
```java    git clone https://github.com/Ziggeo/ZiggeoJavaSdk```

### How to use <a name="how-to-use"></a>

To start using the Java SDK you would need to initialize the Ziggeo class with application token, private token and possibly encryption token. The token and keys can be found within the Ziggeo application once you log into your account, under Overview page.


### Installation<a name="install"></a>

Make sure to install Java Cryptography Extension (JCE) Unlimited Strength.


## Building<a name="build"></a>

mvn clean install

    ## Demo<a name="demo"></a>

    mvn exec:java -Dexec.mainClass=com.ziggeo.demos.VideoListLimit -Dexec.args='TOKEN PRIVATE_KEY SKIP LIMIT'

## Client-Side Integration<a name="codes-client-side"></a>

For the client-side integration, you need to add these assets to your html file:

```html 
<link rel="stylesheet" href="//assets-cdn.ziggeo.com/v2-stable/ziggeo.css" />
<script src="//assets-cdn.ziggeo.com/v2-stable/ziggeo.js"></script>
```

Then, you need to specify your api token:
```html 
<script>
    var ziggeoApplication = new ZiggeoApi.V2.Application({
        token: "APPLICATION_TOKEN",
        webrtc_streaming_if_necessary: true,
        webrtc_on_mobile: true
    });
</script>
```

You can specify other global options, [see here](https://ziggeo.com/docs).

To fire up a recorder on your page, add:
```html 
<ziggeorecorder></ziggeorecorder>
``` 

To embed a player for an existing video, add:
```html 
<ziggeoplayer ziggeo-video='video-token'></ziggeoplayer>
``` 

For the full documentation, please visit [ziggeo.com](https://ziggeo.com/docs).

## Server-Side Integration<a name="codes-server-side"></a>

### Initialize Ziggeo class in your code<a name="codes-init"></a>

You can integrate the Server SDK as follows:

```java 
Ziggeo ziggeo = new Ziggeo("*token*", "*privateKey*", "*encryptionKey*"); 
```

Config is optional and if not specified (recommended), the Config file will be used instead.

### Available Methods<a name="codes-methods"></a>

Currently available methods are branched off within different categories:

1. Videos
2. Streams
3. Authtokens
4. Application
5. Effect Profiles
6. Effect Profile Process
7. Meta Profiles
8. Meta Profile Process
9. Webhooks
10. Analytics

Each of this sections has their own actions and they are explained bellow



### Videos<a name="method-videos"></a>


The videos resource allows you to access all single videos. Each video may contain more than one stream.

#### Index<a name="method-videos-index"></a>

Query an array of videos (will return at most 50 videos by default). Newest videos come first.

```java
ziggeo.videos().index(JSONObject arguments)
```

 Arguments
- limit: *Limit the number of returned videos. Can be set up to 100.*
- skip: *Skip the first [n] entries.*
- reverse: *Reverse the order in which videos are returned.*
- states: *Filter videos by state*
- tags: *Filter the search result to certain tags, encoded as a comma-separated string*

#### Count<a name="method-videos-count"></a>

Get the video count for the application.

```java
ziggeo.videos().count(JSONObject arguments)
```

 Arguments
- states: *Filter videos by state*
- tags: *Filter the search result to certain tags, encoded as a comma-separated string*

#### Get<a name="method-videos-get"></a>

Get a single video by token or key.

```java
ziggeo.videos().get(String tokenOrKey)
```

#### Get Bulk<a name="method-videos-get-bulk"></a>

Get multiple videos by tokens or keys.

```java
ziggeo.videos().getBulk(JSONObject arguments)
```

 Arguments
- tokens_or_keys: *Comma-separated list with the desired videos tokens or keys (Limit: 100 tokens or keys).*

#### Stats Bulk<a name="method-videos-stats-bulk"></a>

Get stats for multiple videos by tokens or keys.

```java
ziggeo.videos().statsBulk(JSONObject arguments)
```

 Arguments
- tokens_or_keys: *Comma-separated list with the desired videos tokens or keys (Limit: 100 tokens or keys).*
- summarize: *Boolean. Set it to TRUE to get the stats summarized. Set it to FALSE to get the stats for each video in a separate array. Default: TRUE.*

#### Download Video<a name="method-videos-download-video"></a>

Download the video data file

```java
ziggeo.videos().downloadVideo(String tokenOrKey)
```

#### Download Image<a name="method-videos-download-image"></a>

Download the image data file

```java
ziggeo.videos().downloadImage(String tokenOrKey)
```

#### Get Stats<a name="method-videos-get-stats"></a>

Get the video's stats

```java
ziggeo.videos().getStats(String tokenOrKey)
```

#### Push To Service<a name="method-videos-push-to-service"></a>

Push a video to a provided push service.

```java
ziggeo.videos().pushToService(String tokenOrKey, JSONObject arguments)
```

 Arguments
- pushservicetoken: *Push Services's token (from the Push Services configured for the app)*

#### Apply Effect<a name="method-videos-apply-effect"></a>

Apply an effect profile to a video.

```java
ziggeo.videos().applyEffect(String tokenOrKey, JSONObject arguments)
```

 Arguments
- effectprofiletoken: *Effect Profile token (from the Effect Profiles configured for the app)*

#### Apply Meta<a name="method-videos-apply-meta"></a>

Apply a meta profile to a video.

```java
ziggeo.videos().applyMeta(String tokenOrKey, JSONObject arguments)
```

 Arguments
- metaprofiletoken: *Meta Profile token (from the Meta Profiles configured for the app)*

#### Update<a name="method-videos-update"></a>

Update single video by token or key.

```java
ziggeo.videos().update(String tokenOrKey, JSONObject arguments)
```

 Arguments
- min_duration: *Minimal duration of video*
- max_duration: *Maximal duration of video*
- tags: *Video Tags*
- key: *Unique (optional) name of video*
- volatile: *Automatically removed this video if it remains empty*
- expiration_days: *After how many days will this video be deleted*
- expire_on: *On which date will this video be deleted. String in ISO 8601 format: YYYY-MM-DD*

#### Update Bulk<a name="method-videos-update-bulk"></a>

Update multiple videos by token or key.

```java
ziggeo.videos().updateBulk(JSONObject arguments)
```

 Arguments
- tokens_or_keys: *Comma-separated list with the desired videos tokens or keys (Limit: 100 tokens or keys).*
- min_duration: *Minimal duration of video*
- max_duration: *Maximal duration of video*
- tags: *Video Tags*
- volatile: *Automatically removed this video if it remains empty*
- expiration_days: *After how many days will this video be deleted*
- expire_on: *On which date will this video be deleted. String in ISO 8601 format: YYYY-MM-DD*

#### Delete<a name="method-videos-delete"></a>

Delete a single video by token or key.

```java
ziggeo.videos().delete(String tokenOrKey)
```

#### Create<a name="method-videos-create"></a>

Create a new video.

```java
ziggeo.videos().create(JSONObject arguments, String file)
```

 Arguments
- file: *Video file to be uploaded*
- min_duration: *Minimal duration of video*
- max_duration: *Maximal duration of video*
- tags: *Video Tags*
- key: *Unique (optional) name of video*
- volatile: *Automatically removed this video if it remains empty*
- effect_profile: *Set the effect profile that you want to have applied to your video.*
- meta_profile: *Set the meta profile that you want to have applied to your video once created.*
- video_profile: *Set the video profile that you want to have applied to your video as you create it.*

#### Analytics<a name="method-videos-analytics"></a>

Get analytics for a specific videos with the given params

```java
ziggeo.videos().analytics(String tokenOrKey, JSONObject arguments)
```

 Arguments
- from: *A UNIX timestamp in microseconds used as the start date of the query*
- to: *A UNIX timestamp in microseconds used as the end date of the query*
- date: *A UNIX timestamp in microseconds to retrieve data from a single date. If set, it overwrites the from and to params.*
- query: *The query you want to run. It can be one of the following: device_views_by_os, device_views_by_date, total_plays_by_country, full_plays_by_country, total_plays_by_hour, full_plays_by_hour, total_plays_by_browser, full_plays_by_browser*

### Streams<a name="method-streams"></a>


The streams resource allows you to directly access all streams associated with a single video.

#### Index<a name="method-streams-index"></a>

Return all streams associated with a video

```java
ziggeo.streams().index(String videoTokenOrKey, JSONObject arguments)
```

 Arguments
- states: *Filter streams by state*

#### Get<a name="method-streams-get"></a>

Get a single stream

```java
ziggeo.streams().get(String videoTokenOrKey, String tokenOrKey)
```

#### Download Video<a name="method-streams-download-video"></a>

Download the video data associated with the stream

```java
ziggeo.streams().downloadVideo(String videoTokenOrKey, String tokenOrKey)
```

#### Download Image<a name="method-streams-download-image"></a>

Download the image data associated with the stream

```java
ziggeo.streams().downloadImage(String videoTokenOrKey, String tokenOrKey)
```

#### Push To Service<a name="method-streams-push-to-service"></a>

Push a stream to a provided push service.

```java
ziggeo.streams().pushToService(String videoTokenOrKey, String tokenOrKey, JSONObject arguments)
```

 Arguments
- pushservicetoken: *Push Services's token (from the Push Services configured for the app)*

#### Delete<a name="method-streams-delete"></a>

Delete the stream

```java
ziggeo.streams().delete(String videoTokenOrKey, String tokenOrKey)
```

#### Create<a name="method-streams-create"></a>

Create a new stream

```java
ziggeo.streams().create(String videoTokenOrKey, JSONObject arguments, String file)
```

 Arguments
- file: *Video file to be uploaded*

#### Attach Image<a name="method-streams-attach-image"></a>

Attaches an image to a new stream

```java
ziggeo.streams().attachImage(String videoTokenOrKey, String tokenOrKey, JSONObject arguments, String file)
```

 Arguments
- file: *Image file to be attached*

#### Attach Video<a name="method-streams-attach-video"></a>

Attaches a video to a new stream

```java
ziggeo.streams().attachVideo(String videoTokenOrKey, String tokenOrKey, JSONObject arguments, String file)
```

 Arguments
- file: *Video file to be attached*

#### Attach Subtitle<a name="method-streams-attach-subtitle"></a>

Attaches a subtitle to the stream.

```java
ziggeo.streams().attachSubtitle(String videoTokenOrKey, String tokenOrKey, JSONObject arguments)
```

 Arguments
- lang: *Subtitle language*
- label: *Subtitle reference*
- data: *Actual subtitle*

#### Bind<a name="method-streams-bind"></a>

Closes and submits the stream

```java
ziggeo.streams().bind(String videoTokenOrKey, String tokenOrKey, JSONObject arguments)
```

 Arguments

### Authtokens<a name="method-authtokens"></a>


The auth token resource allows you to manage authorization settings for video objects.

#### Get<a name="method-authtokens-get"></a>

Get a single auth token by token.

```java
ziggeo.authtokens().get(String token)
```

#### Update<a name="method-authtokens-update"></a>

Update single auth token by token.

```java
ziggeo.authtokens().update(String tokenOrKey, JSONObject arguments)
```

 Arguments
- volatile: *Will this object automatically be deleted if it remains empty?*
- hidden: *If hidden, the token cannot be used directly.*
- expiration_date: *Expiration date for the auth token (Unix epoch time format)*
- usage_expiration_time: *Expiration time per session (seconds)*
- session_limit: *Maximal number of sessions*
- grants: *Permissions this tokens grants*

#### Delete<a name="method-authtokens-delete"></a>

Delete a single auth token by token.

```java
ziggeo.authtokens().delete(String tokenOrKey)
```

#### Create<a name="method-authtokens-create"></a>

Create a new auth token.

```java
ziggeo.authtokens().create(JSONObject arguments)
```

 Arguments
- volatile: *Will this object automatically be deleted if it remains empty?*
- hidden: *If hidden, the token cannot be used directly.*
- expiration_date: *Expiration date for the auth token (Unix epoch time format)*
- usage_expiration_time: *Expiration time per session (seconds)*
- session_limit: *Maximal number of sessions*
- grants: *Permissions this tokens grants*

### Application<a name="method-application"></a>


The application token resource allows you to manage your application.

#### Get<a name="method-application-get"></a>

Read application.

```java
ziggeo.application().get()
```

#### Update<a name="method-application-update"></a>

Update application.

```java
ziggeo.application().update(JSONObject arguments)
```

 Arguments
- volatile: *Will this object automatically be deleted if it remains empty?*
- name: *Name of the application*
- auth_token_required_for_create: *Require auth token for creating videos*
- auth_token_required_for_update: *Require auth token for updating videos*
- auth_token_required_for_read: *Require auth token for reading videos*
- auth_token_required_for_destroy: *Require auth token for deleting videos*
- client_can_index_videos: *Client is allowed to perform the index operation*
- client_cannot_access_unaccepted_videos: *Client cannot view unaccepted videos*
- enable_video_subpages: *Enable hosted video pages*

#### Get Stats<a name="method-application-get-stats"></a>

Read application stats

```java
ziggeo.application().getStats(JSONObject arguments)
```

 Arguments
- period: *Optional. Can be 'year' or 'month'.*

### Effect Profiles<a name="method-effect-profiles"></a>


The effect profiles resource allows you to access and create effect profiles for your app. Each effect profile may contain one process or more.

#### Create<a name="method-effect-profiles-create"></a>

Create a new effect profile.

```java
ziggeo.effectProfiles().create(JSONObject arguments)
```

 Arguments
- key: *Effect profile key.*
- title: *Effect profile title.*
- default_effect: *Boolean. If TRUE, sets an effect profile as default. If FALSE, removes the default status for the given effect*

#### Index<a name="method-effect-profiles-index"></a>

Get list of effect profiles.

```java
ziggeo.effectProfiles().index(JSONObject arguments)
```

 Arguments
- limit: *Limit the number of returned effect profiles. Can be set up to 100.*
- skip: *Skip the first [n] entries.*
- reverse: *Reverse the order in which effect profiles are returned.*

#### Get<a name="method-effect-profiles-get"></a>

Get a single effect profile

```java
ziggeo.effectProfiles().get(String tokenOrKey)
```

#### Delete<a name="method-effect-profiles-delete"></a>

Delete the effect profile

```java
ziggeo.effectProfiles().delete(String tokenOrKey)
```

#### Update<a name="method-effect-profiles-update"></a>

Updates an effect profile.

```java
ziggeo.effectProfiles().update(String tokenOrKey, JSONObject arguments)
```

 Arguments
- default_effect: *Boolean. If TRUE, sets an effect profile as default. If FALSE, removes the default status for the given effect*

### Effect Profile Process<a name="method-effect-profile-process"></a>


The process resource allows you to directly access all process associated with a single effect profile.

#### Index<a name="method-effect-profile-process-index"></a>

Return all processes associated with a effect profile

```java
ziggeo.effectProfileProcess().index(String effectTokenOrKey, JSONObject arguments)
```

 Arguments
- states: *Filter streams by state*

#### Get<a name="method-effect-profile-process-get"></a>

Get a single process

```java
ziggeo.effectProfileProcess().get(String effectTokenOrKey, String tokenOrKey)
```

#### Delete<a name="method-effect-profile-process-delete"></a>

Delete the process

```java
ziggeo.effectProfileProcess().delete(String effectTokenOrKey, String tokenOrKey)
```

#### Create Filter Process<a name="method-effect-profile-process-create-filter-process"></a>

Create a new filter effect process

```java
ziggeo.effectProfileProcess().createFilterProcess(String effectTokenOrKey, JSONObject arguments)
```

 Arguments
- effect: *Effect to be applied in the process*

#### Create Watermark Process<a name="method-effect-profile-process-create-watermark-process"></a>

Attaches an image to a new stream

```java
ziggeo.effectProfileProcess().createWatermarkProcess(String effectTokenOrKey, JSONObject arguments, String file)
```

 Arguments
- file: *Image file to be attached*
- vertical_position: *Specify the vertical position of your watermark (a value between 0.0 and 1.0)*
- horizontal_position: *Specify the horizontal position of your watermark (a value between 0.0 and 1.0)*
- video_scale: *Specify the image scale of your watermark (a value between 0.0 and 1.0)*

#### Edit Watermark Process<a name="method-effect-profile-process-edit-watermark-process"></a>

Edits an existing watermark process.

```java
ziggeo.effectProfileProcess().editWatermarkProcess(String effectTokenOrKey, String tokenOrKey, JSONObject arguments, String file)
```

 Arguments
- file: *Image file to be attached*
- vertical_position: *Specify the vertical position of your watermark (a value between 0.0 and 1.0)*
- horizontal_position: *Specify the horizontal position of your watermark (a value between 0.0 and 1.0)*
- video_scale: *Specify the image scale of your watermark (a value between 0.0 and 1.0)*

### Meta Profiles<a name="method-meta-profiles"></a>


The meta profiles resource allows you to access and create meta profiles for your app. Each meta profile may contain one process or more.

#### Create<a name="method-meta-profiles-create"></a>

Create a new meta profile.

```java
ziggeo.metaProfiles().create(JSONObject arguments)
```

 Arguments
- key: *Meta Profile profile key.*
- title: *Meta Profile profile title.*

#### Index<a name="method-meta-profiles-index"></a>

Get list of meta profiles.

```java
ziggeo.metaProfiles().index(JSONObject arguments)
```

 Arguments
- limit: *Limit the number of returned meta profiles. Can be set up to 100.*
- skip: *Skip the first [n] entries.*
- reverse: *Reverse the order in which meta profiles are returned.*

#### Get<a name="method-meta-profiles-get"></a>

Get a single meta profile

```java
ziggeo.metaProfiles().get(String tokenOrKey)
```

#### Delete<a name="method-meta-profiles-delete"></a>

Delete the meta profile

```java
ziggeo.metaProfiles().delete(String tokenOrKey)
```

### Meta Profile Process<a name="method-meta-profile-process"></a>


The process resource allows you to directly access all process associated with a single meta profile.

#### Index<a name="method-meta-profile-process-index"></a>

Return all processes associated with a meta profile

```java
ziggeo.metaProfileProcess().index(String metaTokenOrKey)
```

#### Get<a name="method-meta-profile-process-get"></a>

Get a single process

```java
ziggeo.metaProfileProcess().get(String metaTokenOrKey, String tokenOrKey)
```

#### Delete<a name="method-meta-profile-process-delete"></a>

Delete the process

```java
ziggeo.metaProfileProcess().delete(String metaTokenOrKey, String tokenOrKey)
```

#### Create Video Analysis Process<a name="method-meta-profile-process-create-video-analysis-process"></a>

Create a new video analysis meta process

```java
ziggeo.metaProfileProcess().createVideoAnalysisProcess(String metaTokenOrKey)
```

#### Create Audio Transcription Process<a name="method-meta-profile-process-create-audio-transcription-process"></a>

Create a new audio transcription meta process

```java
ziggeo.metaProfileProcess().createAudioTranscriptionProcess(String metaTokenOrKey)
```

#### Create Nsfw Process<a name="method-meta-profile-process-create-nsfw-process"></a>

Create a new nsfw filter meta process

```java
ziggeo.metaProfileProcess().createNsfwProcess(String metaTokenOrKey, JSONObject arguments)
```

 Arguments
- nsfw_action: *One of the following three: approve, reject, nothing.*

#### Create Profanity Process<a name="method-meta-profile-process-create-profanity-process"></a>

Create a new profanity filter meta process

```java
ziggeo.metaProfileProcess().createProfanityProcess(String metaTokenOrKey, JSONObject arguments)
```

 Arguments
- profanity_action: *One of the following three: approve, reject, nothing.*

### Webhooks<a name="method-webhooks"></a>


The webhooks resource allows you to create or delete webhooks related to a given application.

#### Create<a name="method-webhooks-create"></a>

Create a new webhook for the given url to catch the given events.

```java
ziggeo.webhooks().create(JSONObject arguments)
```

 Arguments
- target_url: *The url that will catch the events*
- encoding: *Data encoding to be used by the webhook to send the events.*
- events: *Comma-separated list of the events the webhook will catch. They must be valid webhook type events.*

#### Confirm<a name="method-webhooks-confirm"></a>

Confirm a webhook using its ID and the corresponding validation code.

```java
ziggeo.webhooks().confirm(JSONObject arguments)
```

 Arguments
- webhook_id: *Webhook ID that's returned in the creation call.*
- validation_code: *Validation code that is sent to the webhook when created.*

#### Delete<a name="method-webhooks-delete"></a>

Delete a webhook using its URL.

```java
ziggeo.webhooks().delete(JSONObject arguments)
```

 Arguments
- target_url: *The url that will catch the events*

### Analytics<a name="method-analytics"></a>


The analytics resource allows you to access the analytics for the given application

#### Get<a name="method-analytics-get"></a>

Get analytics for the given params

```java
ziggeo.analytics().get(JSONObject arguments)
```

 Arguments
- from: *A UNIX timestamp in microseconds used as the start date of the query*
- to: *A UNIX timestamp in microseconds used as the end date of the query*
- date: *A UNIX timestamp in microseconds to retrieve data from a single date. If set, it overwrites the from and to params.*
- query: *The query you want to run. It can be one of the following: device_views_by_os, device_views_by_date, total_plays_by_country, full_plays_by_country, total_plays_by_hour, full_plays_by_hour, total_plays_by_browser, full_plays_by_browser*





## License <a name="license"></a>

Copyright (c) 2013-2021 Ziggeo
 
Apache 2.0 License
