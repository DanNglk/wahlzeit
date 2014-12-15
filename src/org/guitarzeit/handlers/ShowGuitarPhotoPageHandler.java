package org.guitarzeit.handlers;

import org.guitarzeit.model.Guitar;
import org.guitarzeit.model.GuitarPhoto;
import org.guitarzeit.model.GuitarPhotoManager;
import org.wahlzeit.handlers.PartUtil;
import org.wahlzeit.handlers.ShowPhotoPageHandler;
import org.wahlzeit.model.*;
import org.wahlzeit.utils.StringUtil;
import org.wahlzeit.webparts.WebPart;

import java.util.Map;

/**
 * Created by cdan on 04/12/14.
 */
public class ShowGuitarPhotoPageHandler extends ShowPhotoPageHandler {

    @Override
    protected String doHandleGet(UserSession us, String link, Map args) {
        PhotoManager photoManager = GuitarPhotoManager.getInstance();
        Photo photo = null;

        String arg = us.getAsString(args, "prior");
        if (!StringUtil.isNullOrEmptyString(arg)) {
            us.setPriorPhoto(photoManager.getPhotoFromId(PhotoId.getIdFromString(arg)));
        }

        if (!link.equals(PartUtil.SHOW_PHOTO_PAGE_NAME)) {
            photo = photoManager.getPhotoFromId(PhotoId.getIdFromString(link));
        }

        if (photo == null) {
            PhotoFilter filter = us.getPhotoFilter();
            photo = photoManager.getVisiblePhoto(filter);
            if (photo != null) {
                link = photo.getId().asString();
            }
        }

        us.setPhoto(photo);

        return link;
    }


    @Override
    protected void makePhotoCaption(UserSession us, WebPart page) {
        GuitarPhoto photo = (GuitarPhoto) us.getPhoto();

        WebPart caption = createWebPart(us, PartUtil.CAPTION_INFO_FILE);
        caption.addString(Photo.LOCATION_CAPTION, photo.getLocation().asString());
        caption.addString(Guitar.TYPE_CAPTION, photo.getGuitar().getGuitarType().name());
        caption.addString(Guitar.SHAPE_CAPTION, photo.getGuitar().getGuitarShape().name());
        caption.addString(Guitar.STRINGS_CAPTION, photo.getGuitar().getGuitarStrings().asString());
        caption.addString(Guitar.MANUFACTURER_CAPTION, photo.getGuitar().getGuitarManufacturer().asString());
        caption.addString(Guitar.FRETS_CAPTION, photo.getGuitar().getFrets() + "");
        caption.addString(Guitar.FEATURES_CAPTION, photo.getGuitar().getFeatures());
        caption.addString(Guitar.PICKUPS_CAPTION, photo.getGuitar().getPickups() + "");

        page.addWritable(Photo.CAPTION, caption);
    }
}
