#!/bin/sh

echo "This shell script helps test all direct demos within our /demos/ folder compiled as .exe files"
echo "Script will call some demos with its own pre-defined values."
echo "Your plan has to allow some of the functionality for you to be able to use it"
echo "Note: You will need to compile your files first using \`mvn clean install\` otherwise you will get error"
echo "\n"

app_token=APP_TOKEN
private_key=PRIVATE_KEY
encryption_key=ENCRYPTION_KEY
video_token=VIDEO_TOKEN
stream_token=STREAM_TOKEN
video_file=./assets/video1s.mp4
image_file=./assets/image.png
push_token=PUSH_SERVICE_TOKEN
tags=demos,test,tag_update,php
filter_from="1646089200000"
filter_to="1646521200000"
filter_date=""
filter_query="device_views_by_os"
effect_profile=EFFECT_PROFILE_TOKEN
meta_profile=META_PROFILE_TOKEN
auth_token=SERVER_AUTH_TOKEN
effect_filter=gray # can be: gray, cartoon, lucis, edge, chill, charcoal, sketch
url=https://ziggeo.com/
encoding=jsonheader
events=video_create,video_delete
webhook_id=some_id
validation_code=123456


# Colors
COLOR_GREEN='\033[0;32m' # Green
COLOR_RED='\033[0;31m' # Red
COLOR_END='\033[0m'    # No Color


#########
# Demos #
#########

count_demos=0
count_with_errors=0

now=$(date +"%T")
echo "\n\n****************************************************************************************" >> run_demos_log.log
echo "\nCurrent time : $now" >> run_demos_log.log
echo "\n****************************************************************************************" >> run_demos_log.log


run_demo()
{
	demo_name=$1
	shift
	arguments=$@
	echo "\nRunning demo: $demo_name"
	echo "\nmvn exec:java -Dexec.mainClass=com.ziggeo.demos.$demo_name -Dexec.args='$arguments'"
	mvn exec:java -Dexec.mainClass="com.ziggeo.demos.$demo_name" -Dexec.args="$arguments" >> run_demos_log.log
	result=$?
	count_demos=$((count_demos+1))

	if [ $result -ne 0 ]; then
		echo "\n${COLOR_RED}There was an error running${COLOR_END} $demo_name"
		echo "\nThere was an error running $demo_name" >> run_demos_log.log
		count_with_errors=$((count_with_errors+1))
		sleep 2
	else
		echo "${COLOR_GREEN}SUCCESS${COLOR_END}: The $demo_name finished without any errors"
		echo "SUCCESS: The $demo_name finished without any errors" >> run_demos_log.log
	fi

	sleep 2
}


# Videos
run_demo VideosCount $app_token $private_key
run_demo VideosIndex $app_token $private_key
run_demo VideosDownloadImage $app_token $private_key $video_token
run_demo VideosDownloadVideo $app_token $private_key $video_token
run_demo VideosCreate $app_token $private_key $video_file


# Streams


# Analytics


# Application
run_demo ApplicationGetStats $app_token $private_key


# Authtokens
run_demo AuthtokensCreate $app_token $private_key
run_demo AuthGenerate $app_token $private_key $encryption_key


# Effect Profiles


# Meta Profiles


# Webhook


# Permanent


echo "Done! We have gone through all $count_demos demos"

if [ $count_with_errors -ge 1 ]; then
	echo "\n$count_with_errors out of $count_demos finished with the error"
fi