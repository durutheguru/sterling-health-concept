(function(_$$) {

    _$$.util.registerComponents({
        faqItem : {

            el : ".faq-item",

            methods : {

                deleteFAQ : function(faqId) {
                    _$$.util.logInfo("FAQ ID: " + faqId);
                }

            }

        }
    });

})(rootObject);