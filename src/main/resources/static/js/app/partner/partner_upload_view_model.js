(function (_$$) {


    _$$.util.registerComponents({
        partnerUploadViewModel : new Vue({
            el : "#partner-upload-container",

            data : {
                file : null,
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

                disabled : function() {
                    return this.file == null;
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
                },

                quantity : _$$.util.quantity

            },

            mounted : function() {
                var self = this;
                self.$root.$on('partnersLoaded', function (partners) {
                    self.partnerCount = partners.length;
                });
            }
        })
    });


})(rootObject);