# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

---
## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [x] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [x] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [x] Implement a shared element transition when user clicks into the details of a movie (1 point).
- [x] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [x] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [x] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [x] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [ ] Apply data binding for views to help remove boilerplate code. (1 point)
- [x] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF

<b>PORTRAIT MODE:</b>

<img src='FlixsterUnit2Portrait.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<b>LANDSCAPE MODE:</b>

<img src='FlixsterUnit2Landscape.gif' title='Video Walkthrough1' width='' alt='Video Walkthrough1' />

### Notes
The most challenging part was understanding how to prioritize the stretch stories. For example I started doing the data bindings story but then I figured that the rest of the stories were more related. Hence when I deleted myt code and pushed to Github I had many conflicts and issues that forced me to merge, at the end that broke my code. It would've been much easier if from the beginning I read all the stories first to plan out a execution strategy.

## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android