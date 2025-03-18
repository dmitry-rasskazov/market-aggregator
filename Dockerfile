ARG RUNTIME_IMAGE=quay.io/wildfly/wildfly-runtime:latest

FROM ${RUNTIME_IMAGE} AS data-access-subsystem
COPY --chown=jboss:root data-access-subsystem/target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME


FROM ${RUNTIME_IMAGE} AS data-management-subsystem
COPY --chown=jboss:root data-management-subsystem/target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME


FROM ${RUNTIME_IMAGE} AS information-parsing-subsystem
COPY --chown=jboss:root information-parsing-subsystem/target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME


FROM ${RUNTIME_IMAGE} AS resource-adaptations-subsystem
COPY --chown=jboss:root resource-adaptations-subsystem/target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME