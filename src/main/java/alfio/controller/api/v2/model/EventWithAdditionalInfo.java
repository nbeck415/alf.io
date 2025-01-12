/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.controller.api.v2.model;

import alfio.model.Event;
import alfio.model.Event.EventFormat;
import alfio.model.PurchaseContext;
import alfio.model.user.Organization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.List;
import java.util.Map;

public class EventWithAdditionalInfo implements DateValidity, ApiPurchaseContext {
    private final Event event;
    private final String mapUrl;
    private final Organization.OrganizationContact organization;
    private final Map<String, String> description;

    //payment related information
    private final String bankAccount;
    private final List<String> bankAccountOwner;
    //

    //date related information
    private final Map<String, String> formattedBeginDate; // day, month, year
    private final Map<String, String> formattedBeginTime; //the hour/minute component
    private final Map<String, String> formattedEndDate;
    private final Map<String, String> formattedEndTime;
    //

    //
    private final InvoicingConfiguration invoicingConfiguration;
    //

    //
    private final CaptchaConfiguration captchaConfiguration;
    //

    //
    private final AssignmentConfiguration assignmentConfiguration;
    //

    //
    private final PromotionsConfiguration promotionsConfiguration;
    //

    private final AnalyticsConfiguration analyticsConfiguration;

    private final OfflinePaymentConfiguration offlinePaymentConfiguration;

    private final Map<String, Map<String, String>> i18nOverride;

    private final Integer availableTicketsCount;

    private final String customCss;

    private final boolean canApplySubscriptions;

    public EventWithAdditionalInfo(Event event,
                                   String mapUrl,
                                   Organization.OrganizationContact organization,
                                   Map<String, String> description,
                                   String bankAccount,
                                   List<String> bankAccountOwner,
                                   Map<String, String> formattedBeginDate,
                                   Map<String, String> formattedBeginTime,
                                   Map<String, String> formattedEndDate,
                                   Map<String, String> formattedEndTime,
                                   InvoicingConfiguration invoicingConfiguration,
                                   CaptchaConfiguration captchaConfiguration,
                                   AssignmentConfiguration assignmentConfiguration,
                                   PromotionsConfiguration promotionsConfiguration,
                                   AnalyticsConfiguration analyticsConfiguration,
                                   OfflinePaymentConfiguration offlinePaymentConfiguration,
                                   Map<String, Map<String, String>> i18nOverride,
                                   Integer availableTicketsCount,
                                   String customCss,
                                   boolean canApplySubscriptions) {
        this.event = event;
        this.mapUrl = mapUrl;
        this.organization = organization;
        this.description = description;
        this.bankAccount = bankAccount;
        this.bankAccountOwner = bankAccountOwner;
        this.formattedBeginDate = formattedBeginDate;
        this.formattedBeginTime = formattedBeginTime;
        this.formattedEndDate = formattedEndDate;
        this.formattedEndTime = formattedEndTime;
        this.invoicingConfiguration = invoicingConfiguration;
        this.captchaConfiguration = captchaConfiguration;
        this.assignmentConfiguration = assignmentConfiguration;
        this.promotionsConfiguration = promotionsConfiguration;
        this.analyticsConfiguration = analyticsConfiguration;
        this.offlinePaymentConfiguration = offlinePaymentConfiguration;
        this.i18nOverride = i18nOverride;
        this.availableTicketsCount = availableTicketsCount;
        this.customCss = customCss;
        this.canApplySubscriptions = canApplySubscriptions;
    }

    public String getShortName() {
        return event.getShortName();
    }

    public String getDisplayName() {
        return event.getDisplayName();
    }

    public String getFileBlobId() {
        return event.getFileBlobId();
    }

    public String getWebsiteUrl() {
        return event.getWebsiteUrl();
    }

    public Integer getAvailableTicketsCount() {
        return availableTicketsCount;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    @Override
    public String getOrganizationName() {
        return organization.getName();
    }

    @Override
    public String getOrganizationEmail() {
        return organization.getEmail();
    }

    public String getLocation() {
        return event.getLocation();
    }

    @Override
    public Map<String, String> getDescription() {
        return description;
    }

    @Override
    public String getPrivacyPolicyUrl() {
        return event.getPrivacyPolicyLinkOrNull();
    }

    @Override
    public String getTermsAndConditionsUrl() {
        return event.getTermsAndConditionsUrl();
    }

    @Override
    public String getCurrency() {
        return event.getCurrency();
    }

    @Override
    public boolean isVatIncluded() {
        return event.isVatIncluded();
    }

    @Override
    public String getVat() {
        return event.getVat().toString();
    }

    @Override
    public boolean isFree() {
        return event.getFree();
    }

    @Override
    public String getBankAccount() {
        return bankAccount;
    }

    @Override
    public List<String> getBankAccountOwner() {
        return bankAccountOwner;
    }


    // date related fields
    @Override
    public boolean isSameDay() {
        return event.getSameDay();
    }

    @Override
    public Map<String, String> getFormattedBeginDate() {
        return formattedBeginDate;
    }

    @Override
    public Map<String, String> getFormattedBeginTime() {
        return formattedBeginTime;
    }

    @Override
    public Map<String, String> getFormattedEndDate() {
        return formattedEndDate;
    }

    @Override
    public Map<String, String> getFormattedEndTime() {
        return formattedEndTime;
    }

    @Override
    public String getTimeZone() {
        return event.getTimeZone();
    }

    @Override
    public DatesWithTimeZoneOffset getDatesWithOffset() {
        return DatesWithTimeZoneOffset.fromEvent(event);
    }

    //


    @Override
    public InvoicingConfiguration getInvoicingConfiguration() {
        return invoicingConfiguration;
    }

    @Override
    public CaptchaConfiguration getCaptchaConfiguration() {
        return captchaConfiguration;
    }

    @Override
    public AssignmentConfiguration getAssignmentConfiguration() {
        return assignmentConfiguration;
    }

    public PromotionsConfiguration getPromotionsConfiguration() {
        return promotionsConfiguration;
    }

    @Override
    public AnalyticsConfiguration getAnalyticsConfiguration() {
        return analyticsConfiguration;
    }

    public Map<String, Map<String, String>> getI18nOverride() {
        return i18nOverride;
    }

    public EventFormat getFormat() {
        return event.getFormat();
    }

    public String getCustomCss() {
        return customCss;
    }

    @Override
    public Map<String, String> getTitle() {
        return event.getTitle();
    }


    @Override
    public OfflinePaymentConfiguration getOfflinePaymentConfiguration() {
        return offlinePaymentConfiguration;
    }

    @Getter
    public static class CaptchaConfiguration {
        private final boolean captchaForTicketSelection;
        private final boolean captchaForOfflinePaymentAndFree;
        private final String recaptchaApiKey;

        public CaptchaConfiguration(boolean captchaForTicketSelection, boolean captchaForOfflinePaymentAndFree, String recaptchaApiKey) {
            this.captchaForTicketSelection = captchaForTicketSelection;
            this.captchaForOfflinePaymentAndFree = captchaForOfflinePaymentAndFree;
            this.recaptchaApiKey = recaptchaApiKey;
        }
    }

    @Getter
    public static class AssignmentConfiguration {
        private final boolean forceAssignment;
        private final boolean enableAttendeeAutocomplete;
        private final boolean enableTicketTransfer;

        public AssignmentConfiguration(boolean forceAssignment, boolean enableAttendeeAutocomplete, boolean enableTicketTransfer) {
            this.forceAssignment = forceAssignment;
            this.enableAttendeeAutocomplete = enableAttendeeAutocomplete;
            this.enableTicketTransfer = enableTicketTransfer;
        }
    }

    @Getter
    public static class PromotionsConfiguration {
        private final boolean hasAccessPromotions;
        private final boolean usePartnerCode;

        public PromotionsConfiguration(boolean hasAccessPromotions, boolean usePartnerCode) {
            this.hasAccessPromotions = hasAccessPromotions;
            this.usePartnerCode = usePartnerCode;
        }
    }

    @JsonIgnore
    @Override
    public PurchaseContext purchaseContext() {
        return event;
    }

    @Override
    public boolean isCanApplySubscriptions() {
        return canApplySubscriptions;
    }
}
