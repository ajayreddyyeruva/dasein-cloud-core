package org.dasein.cloud.identity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;

/**
 * @author Stas Maksimov (stas.maksimov@software.dell.com)
 * @since 2015.09
 */
@SuppressWarnings("unused")
public class CloudPolicyRule {
    private CloudPermission permission;
    private String          resourceId;
    private ServiceAction[] actions;
    private boolean         exceptActions;

    /**
     * Construct a new cloud policy rule instance
     * @param permission Does policy allow or deny the actions
     * @param actions Which actions does the policy govern, all if empty
     * @param resourceId Which resource does the policy govern, any resource if {@code null}
     * @return new cloud policy rule instance
     */
    public static CloudPolicyRule getInstance(
            @Nonnull CloudPermission permission,
            @Nonnull ServiceAction[] actions,
            @Nullable String resourceId) {
        return new CloudPolicyRule(permission, actions, false, resourceId);
    }

    /**
     * Construct a new cloud policy rule instance
     * @param permission Does policy allow or deny the actions
     * @param actions Which actions does the policy govern, all if empty
     * @param exceptActions Indicates if the permission will apply to all actions except the ones defined in this rule
     * @param resourceId Which resources does the policy govern, <code>null</code> for any resource
     * @return new cloud policy rule instance
     */
    public static CloudPolicyRule getInstance(@Nonnull CloudPermission permission, @Nonnull ServiceAction[] actions, boolean exceptActions, @Nullable String resourceId) {
        return new CloudPolicyRule(permission, actions, exceptActions, resourceId);
    }

    private CloudPolicyRule(CloudPermission permission, ServiceAction[] actions, boolean exceptActions, String resourceId) {
        this.actions = actions;
        this.permission = permission;
        this.resourceId = resourceId;
        this.exceptActions = exceptActions;
    }

    /**
     * Permission of a cloud policy rule: allow or deny
     * @return Type of permission of a cloud policy rule
     */
    public CloudPermission getPermission() {
        return permission;
    }

    /**
     * Resource ID to which the cloud police rule applies
     * @return resource identifier to which the policy rule applies, {@code null} for any resource
     */
    public @Nullable String getResourceId() {
        return resourceId;
    }

    /**
     * Actions that are allowed or denied on the defined resource
     * @return actions
     */
    public @Nonnull ServiceAction[] getActions() {
        return actions;
    }

    /**
     * Indicates whether the permission applies to the actions of the rule or all other actions
     * @return {@code true} if the permission applies to all other actions, {@code false} if the permission applies to
     * actions defined in the rule
     */
    public boolean isExceptActions() {
        return exceptActions;
    }

    @Override
    public @Nonnull String toString() {
        return permission
                + ": "
                + (exceptActions ? "NOT " : "")
                + (actions.length == 0 ? "ANY" : Arrays.toString(actions))
                + "/"
                + (resourceId == null ? "ANY" : resourceId);
    }

}
