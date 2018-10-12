(function(_$$) {

    _$$.util.registerComponents({
        homeImageSlider : new Vue({
            el : ".home-image-slider",

            data : {},

            methods : {

                initSlider : function() {
                    $('.home-image-slider').slick({
                        dots: true,
                        speed: 500,
                        fade: true,
                        cssEase: 'linear'
                    });
                }

            },

            mounted : function() {
                this.initSlider();
            }
        })
    });

})(rootObject);