package org.broad.igv.gwas;

import org.broad.igv.feature.AbstractFeature;
import org.broad.igv.feature.Exon;
import org.broad.igv.feature.IGVFeature;
import org.broad.igv.feature.Strand;
import org.broad.igv.track.WindowFunction;
import org.broad.igv.util.collections.MultiMap;
import org.broad.tribble.Feature;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Represents an eQTL value
 * <p/>
 * SNP	SNP_Chr	SNP_Pos	Gen_ID	Gene_Name	Gene_Pos	T_Stat	P_Val	Q_Val
 * rs1569471	1	169564130	ENSG00000000460.11	C1orf112	169631245	-4.187361378	7.79E-05	0.04794564
 */
public class EQTLFeature extends AbstractFeature {

    private String snp;
    String chr;
    int position;
    private String geneId;
    private String geneName;
    Map<String, String> attributes;

    public EQTLFeature(String snp, String chr, int position, String geneId, String geneName,
                       Map<String, String> attributes) {
        this.snp = snp;
        this.chr = chr;
        this.position = position;
        this.geneId = geneId;
        this.geneName = geneName;

        this.attributes = attributes;
    }

    @Override
    public String getChr() {
        return chr;
    }

    @Override
    public int getStart() {
        return position;
    }

    @Override
    public int getEnd() {
        return position + 1;
    }


    public String getSnp() {
        return snp;
    }

    public String getGeneId() {
        return geneId;
    }

    public String getGeneName() {
        return geneName;
    }

    @Override
    public String getValueString(double position, WindowFunction windowFunction) {
        StringBuilder sb = new StringBuilder();
        sb.append(snp);
        sb.append("<br>" + geneId);
        sb.append("<br>" + geneName);
        for(Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append("<br>" + entry.getKey() + " = " + entry.getValue());
        }
        return sb.toString();

    }

    @Override
    public String getURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
