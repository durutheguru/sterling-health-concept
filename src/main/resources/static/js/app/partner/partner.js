(function (_$$) {

    _$$.util.merge({
        partnerService : {

            loadPartners : function(successHandler, errorHandler) {
                axios
                    .get(_$$.env.url + "/api/v1/partner")
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
            }

        }
    }, _$$.services);


    _$$.util.merge({
        partnerListViewModel : new Vue({
            el: "#partner-list-container",

            data: {
                partners: [],
                partnersLoading: false
            },

            methods: {

                loadPartners: function () {
                    var self = this;
                    self.partnersLoading = true;

                    _$$.services.partnerService.loadPartners(
                        function (response) {
                            self.partnersLoading = false;
                            self.partners = response.data;
                            //self.$root.$emit('partnersLoaded', self.partners);
                            _$$.components.partnerUploadViewModel.setPartnerCount(self.partners.length);
                        },

                        function (error) {
                            self.partnersLoading = false;
                            _$$.util.logError(error.message);
                        }
                    );
                },

                managedString: _$$.util.managedString

            },

            mounted: function () {
                this.loadPartners();
            }
        }),

        partnerUploadViewModel : new Vue({
            el : "#partner-upload-container",

            data : {
                file : '',
                fileUploading : false,
                uploadError : '',
                uploadSuccess : false,
                partnerCount : 0
            },

            methods : {

                selectFile : function() {
                    _$$.util.logInfo("Selected File...");
                    this.file = this.$refs.file.files[0];
                },

                preUpload : function() {
                    this.uploadError = '';
                    this.uploadSuccess = false;
                    this.fileUploading = true;
                },

                successfulUpload : function(response) {
                    this.fileUploading = false;
                    this.uploadSuccess = true;
                    _$$.util.logInfo(JSON.stringify(response));

                    setTimeout(function() {
                        location.reload(true);
                    }, 3000);
                },

                failedUpload : function(error) {
                    this.fileUploading = false;
                    this.uploadError = _$$.util.extractError(error);
                    _$$.util.logError("Upload Error: " + this.uploadError);
                },

                doUpload : function() {
                    var self = this;

                    var formData = new FormData();
                    formData.append("file", this.file);

                    self.preUpload();

                    _$$.services.partnerService.uploadPartners(
                        formData,

                        function(response) {
                            self.successfulUpload(response);
                        },

                        function(error) {
                            self.failedUpload(error);
                        }
                    );
                },

                setPartnerCount : function(count) {
                    _$$.util.logInfo("Setting Partner Count: " + count);
                    this.partnerCount = count;
                }

            },

            mounted : function() {
                var self = this;
                self.$root.$on('partnersLoaded', function (partners) {
                    self.partnerCount = partners.length;
                });
            }
        })
    }, _$$.components);



})(rootObject);