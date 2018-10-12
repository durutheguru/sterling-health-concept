var gulp = require('gulp');
var uglify = require('gulp-uglify');
var concat = require('gulp-concat');

var baseJSFiles = [
    // 3rd party
    'js/jquery.js',
    'js/bootstrap.min.js',
    'js/jquery.dcjqaccordion.2.7.js',
    'js/jquery.scrollTo.min.js',
    'js/jquery.nicescroll.js',
    'js/jquery.sparkline.js',
    'js/jquery-migrate-1.2.1.min.js',
    'assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js',
    'js/owl.carousel.js',
    'js/jquery.customSelect.min.js',
    'js/respond.min.js',
    'js/slidebars.min.js',
    'js/common-scripts.js',
    'js/sparkline-chart.js',
    'js/easy-pie-chart.js',
    'js/slick.min.js',
    'js/count.js',
    'js/axios.min.js',
    'js/vue.min.js',

    // local
    'js/app/main.js',
    'js/app/util.js',
    'js/app/const.js',
    'js/app/web.js'
];



//home minified js
gulp.task('compress-home', function() {
   gulp.src(
       baseJSFiles.concat([
           'js/app/home.js'
       ]))
       .pipe(concat('app.min.js'))
       .pipe(uglify())
       .pipe(gulp.dest('./js/app/'))
});


//partner minified js
gulp.task('compress-partner', function() {
    gulp
        .src(
        baseJSFiles.concat([
        'js/app/partner/partner.service.js',
        'js/app/partner/partner_search_input.js',
        'js/app/partner/partner_card_template.js',
        'js/app/partner/partner_list_view_model.js',
        'js/app/partner/partner_upload_view_model.js',
        'js/app/partner/partner_profile_container.js',
        'js/app/partner/partner_edit_details_form.js'
        ]))
        .pipe(concat('app.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('./js/app/partner/'))
});


//faqs minified js
gulp.task('compress-faq', function() {
    gulp.src(
        baseJSFiles.concat([
            'js/app/faq/faq_list.js'
        ]))
        .pipe(concat('app.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('./js/app/faq/'))
});


