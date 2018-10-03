(function(_$$) {


    _$$.util.registerServices({
        partnerService : {

            loadPartners : function(successHandler, errorHandler) {
                axios
                    .get(_$$.env.url + "/api/v1/partner")
                    .then(successHandler)
                    .catch(errorHandler);
            },

            searchPartners : function(key, successHandler, errorHandler) {
                axios
                    .get(_$$.env.url + "/api/v1/partner/search?key=" + key)
                    .then(successHandler)
                    .catch(errorHandler);
            },

            uploadPartners : function(formData, successHandler, errorHandler) {
                axios
                    .post(
                    _$$.env.url + "/api/v1/partner/upload", formData,
                    {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    }
                )
                    .then(successHandler)
                    .catch(errorHandler);
            },

            getPartnerLogoImage : function(partner) {
                var logoUID = _$$.util.deepGet(partner, "partnerProfile.logo1.uid");
                if (logoUID == null) {
                    return _$$.constants.RESOURCES.DEFAULT_LOGO_PATH;
                }

                return _$$.constants.RESOURCES.IMAGE_URL_ROOT + "/" + logoUID;
            }

        }
    });


})(rootObject);