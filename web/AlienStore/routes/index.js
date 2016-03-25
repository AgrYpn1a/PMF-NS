var express = require('express');
var router = express.Router();

router.get('/', function(req, res, next) {
  res.render('index', {title: "Home"});
});

router.get('/about', function(req, res, next) {
  res.render('about');
});

router.get('/aliens', function(req, res, next) {
  res.render('aliens');
});

router.get('/contact', function(req, res, next) {
  res.render('contact');
});

router.post('/contact/send', function(req, res, next) {
	res.send("<h1>Successfuly sent us message, with following info: </h1> </br> Name: <b>" + req.body.name + "</b> </br> Id: <b>" + req.body.id + "</b></br> Email: <i>" + req.body.email + "</i> </br></br><a href='/'>back</a>");
}); 


module.exports = router;
