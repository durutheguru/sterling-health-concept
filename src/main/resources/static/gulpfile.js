var gulp = require('gulp');
var uglify = require('gulp-uglify');
var concat = require('gulp-concat');

var vendorJSFiles = [
    'js/jquery.js',
    'js/bootstrap.min.js',
    'js/jquery.dcjqaccordion.2.7.js',
    'js/jquery.scrollTo.min.js',
    'js/jquery.nicescroll.js',
    'js/jquery.sparkline.js',
    'assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js',
    'js/owl.carousel.js',
    'js/jquery.customSelect.min.js',
    'js/respond.min.js',
    'js/slidebars.min.js',
    'js/common-scripts.js',
    'js/sparkline-chart.js',
    'js/easy-pie-chart.js',
    'js/count.js',
    'js/axios.min.js',
    'js/vue.min.js'
];


gulp.task('compress-partner', function() {
    gulp
        .src(
        vendorJSFiles.concat([
        'js/app/main.js',
        'js/app/util.js',
        'js/app/const.js',
        'js/app/partner/partner.service.js',
        'js/app/partner/partner_search_input.js',
        'js/app/partner/partner_card_template.js',
        'js/app/partner/partner_list_view_model.js',
        'js/app/partner/partner_upload_view_model.js'
        ]))
        .pipe(concat('app.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('./js/app/partner/'))
});
