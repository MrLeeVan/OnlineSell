@org.jboss.arquillian.container.test.api.Deployment
public static org.jboss.shrinkwrap.api.spec.JavaArchive ${DEPLOYMENT_NAME}(){
  return org.jboss.shrinkwrap.api.ShrinkWrap.create(org.jboss.shrinkwrap.api.spec.JavaArchive.class)
  .addAsManifestResource(org.jboss.shrinkwrap.api.asset.EmptyAsset.INSTANCE,"beans.xml");
  }