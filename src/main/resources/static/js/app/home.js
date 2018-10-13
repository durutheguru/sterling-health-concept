(function(_$$) {

    _$$.util.registerComponents({
        homeImageSlider : new Vue({
            el : ".home-image-slider",

            data : {},

            methods : {

                initSlider : function() {
                    $('.home-image-slider').slick({
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        autoplay: true,
                        autoplaySpeed: 3000
                    });
                }

            },

            mounted : function() {
                this.initSlider();
            }
        })
    });

})(rootObject);