(function(_$$) {

    _$$.util.registerConstants({

        VIEW_MODE : {
            PARTNER_LIST : 'partner.list',
            PARTNER_SEARCH_RESULTS : 'partner.search.results'
        },

        EVENTS : {

            PARTNER_SEARCH : 'partner.search',

            PARTNER_CLEAR_SEARCH : 'partner.search.clear',

            PARTNER_UPDATE_RESULT_MODAL : 'partner.update.modal.data'

        },

        RESOURCES : {

            IMAGE_URL_ROOT : _$$.env.url + "/api/v1/img",

            DEFAULT_LOGO_PATH : "img/photos/web_logo_default.png"

        }

    });

})(rootObject);